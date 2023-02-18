package com.example.lecture16.service;

import com.example.lecture16.documents.Pep;
import com.example.lecture16.repository.PepRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportDataToMongoDBFromJSONImpl implements ImportDataToMongoDBFromJSON {
    final
    PepRepository pepRepository;

    @Autowired
    public ImportDataToMongoDBFromJSONImpl(PepRepository pepRepository) {
        this.pepRepository = pepRepository;
    }

    @Override
    public int parseAndSaveToDB() throws IOException {
        final String PATH = System.getProperty("user.dir");
        final String SEPARATOR = System.getProperty("file.separator");
        String filePath = PATH + SEPARATOR + "uploads" + SEPARATOR + "pep.json";
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        List<Pep> list = new ArrayList<>();
        pepRepository.deleteAll();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            list.addAll(objectMapper.readValue(br, new TypeReference<List<Pep>>() {
            }));
        }

        int count = list.size();
        pepRepository.saveAll(list);
        return count;

    }
}