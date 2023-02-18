package com.example.lecture16.controller;

import com.example.lecture16.service.ImportDataToMongoDBFromJSON;
import com.example.lecture16.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/fileUpload")
public class FileController {
    UploadFileService uploadFileService;
    ImportDataToMongoDBFromJSON importDataToMongoDBFromJSON;

    @Autowired
    public FileController(UploadFileService uploadFileService, ImportDataToMongoDBFromJSON importDataToMongoDBFromJSON) {
        this.uploadFileService = uploadFileService;
        this.importDataToMongoDBFromJSON = importDataToMongoDBFromJSON;
    }

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        uploadFileService.storeFile(file);
        System.out.println("File was uploaded and unzipped successfully!");
        System.out.println("Starting import data from json file to MongoDB...");

        System.out.println("Import data to DB was finished successfully! "
                + importDataToMongoDBFromJSON.parseAndSaveToDB() + " documents was added to collection.");

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
