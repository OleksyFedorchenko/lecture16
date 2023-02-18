package com.example.lecture16.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadFileService {
    void storeFile(MultipartFile file) throws IOException;

    void unzipFile(String zipFileName) throws IOException;

}
