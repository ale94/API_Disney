package com.domain.alkemy.service;

import com.domain.alkemy.models.Gender;
import com.domain.alkemy.repository.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService implements IGenderService {

    @Autowired
    GenderRepository genderRepository;

    @Override
    public void addGender(Gender gender) {
        genderRepository.save(gender);
    }
}
