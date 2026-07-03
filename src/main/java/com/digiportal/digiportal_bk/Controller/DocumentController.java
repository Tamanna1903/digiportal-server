package com.digiportal.digiportal_bk.Controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.digiportal.digiportal_bk.Model.DocumentEntity;
import com.digiportal.digiportal_bk.Service.DocumentServiceImpl;

@RestController
@RequestMapping("api/documents")
@CrossOrigin(origins="*")
public class DocumentController {
    
    private final DocumentServiceImpl documentService;

    public DocumentController(DocumentServiceImpl documentService){
        this.documentService=documentService;
    }
     @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadDocument(
            @RequestParam("username") String username,
            @RequestParam("documentType") String documentType,
            @RequestParam("documentNumber") String documentNumber,
            @RequestParam("file") MultipartFile file) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a valid file to upload.");
        }


        if (!"application/pdf".equals(file.getContentType())) {
            return ResponseEntity.badRequest().body("Invalid file type. Only PDF files are permitted.");
        }

        try {
            documentService.saveDocumentEntity(username, documentType, documentNumber, file);
            return ResponseEntity.ok("Document securely locked and saved to database successfully.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to process document upload: " + e.getMessage());
        }
    }
 @GetMapping("/download/{username}")
    public ResponseEntity<byte[]> downloadDocument(@PathVariable String username) {
        try {
            DocumentEntity document = documentService.getDocumentByUsername(username);

            return ResponseEntity.ok()
                    .contentType(MediaType.APPLICATION_PDF)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + username + "_document.pdf\"")
                    .body(document.getDocumentData());
                    
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
}
