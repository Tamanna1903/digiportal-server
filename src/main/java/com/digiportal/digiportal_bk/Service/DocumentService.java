package com.digiportal.digiportal_bk.Service;
import org.springframework.web.multipart.MultipartFile;

import com.digiportal.digiportal_bk.Model.DocumentEntity;

public interface DocumentService {
DocumentEntity saveDocumentEntity(String username, String docType, String docNumber, MultipartFile file);
DocumentEntity getDocumentByUsername(String username);
}
