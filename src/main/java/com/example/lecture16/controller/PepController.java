package com.example.lecture16.controller;

import com.example.lecture16.dto.FindPerson;
import com.example.lecture16.dto.PopularNamesAggregation;
import com.example.lecture16.service.PepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pep")
public class PepController {
    PepService pepService;

    @Autowired
    public PepController(PepService pepService) {
        this.pepService = pepService;
    }

    @GetMapping("/findFirstName/{first_name_en}")
    public ResponseEntity<List<FindPerson>> getPepByFirstNameEn(@PathVariable String first_name_en) {
        return ResponseEntity.ok(pepService.findByFirstNameEn(first_name_en));
    }

    @GetMapping("/findLastName/{last_name_en}")
    public ResponseEntity<List<FindPerson>> getPepByLastNameEn(@PathVariable String last_name_en) {
        return ResponseEntity.ok(pepService.findByLastNameEn(last_name_en));
    }

    @GetMapping("/popularNames")
    public ResponseEntity<List<PopularNamesAggregation>> getPopularNames() {
        return ResponseEntity.ok(pepService.getPopularNames());
    }
}
