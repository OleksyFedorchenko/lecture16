package com.example.lecture16.service;

import com.example.lecture16.dto.FindPerson;
import com.example.lecture16.dto.PopularNamesAggregation;

import java.util.List;

public interface PepService {
    List<FindPerson> findByFirstNameEn(String firstNameEn);

    List<FindPerson> findByLastNameEn(String lastNameEn);

    List<PopularNamesAggregation> getPopularNames();
}
