package com.digiportal.digiportal_bk.Service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.digiportal.digiportal_bk.Model.DocumentEntity;
import com.digiportal.digiportal_bk.Repository.DocumentRepository; 

@Service
public class DocumentServiceImpl {

    private final DocumentRepository documentRepository;

  
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public DocumentEntity saveDocumentEntity(String username, String docType, String docNumber, MultipartFile file) {
        try {
            DocumentEntity document = new DocumentEntity();
            document.setUsername(username);
            document.setDocumentType(docType);
            document.setDocumentNumber(docNumber);
            document.setActive(true);
            
            document.setDocumentData(file.getBytes());
            
            return documentRepository.save(document);
        } catch (IOException e) {
            throw new RuntimeException("The data bytes from the file could not be read", e);
        }
    }
     public DocumentEntity getDocumentByUsername(String username) {
        return documentRepository.findById(username)
                .orElseThrow(() -> new RuntimeException("No locked documents found for user: " + username));
    }
}