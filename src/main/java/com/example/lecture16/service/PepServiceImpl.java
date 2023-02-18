package com.example.lecture16.service;

import com.example.lecture16.documents.Pep;
import com.example.lecture16.dto.FindPerson;
import com.example.lecture16.dto.PopularNamesAggregation;
import com.example.lecture16.repository.PepRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PepServiceImpl implements PepService {
    PepRepository pepRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public PepServiceImpl(PepRepository pepRepository) {
        this.pepRepository = pepRepository;
    }

    @Override
    public List<FindPerson> findByFirstNameEn(String firstNameEn) {
        List<FindPerson> list = new ArrayList<>();
        List<Pep> pep = pepRepository.findPepByFirst_name_enOrderByFirst_name_en(firstNameEn);
        for (Pep p : pep) {
            list.add(modelMapper.map(p, FindPerson.class));
        }
        return list;
    }

    @Override
    public List<FindPerson> findByLastNameEn(String lastNameEn) {
        List<FindPerson> list = new ArrayList<>();
        List<Pep> pep = pepRepository.findPepByLast_name_enOrderByLast_name_en(lastNameEn);
        for (Pep p : pep) {
            list.add(modelMapper.map(p, FindPerson.class));
        }
        return list;
    }

    @Override
    public List<PopularNamesAggregation> getPopularNames() {
        return pepRepository.getPopularNames();
    }
}
