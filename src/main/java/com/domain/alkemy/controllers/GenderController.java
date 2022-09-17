package com.domain.alkemy.controllers;

import com.domain.alkemy.models.Gender;
import com.domain.alkemy.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GenderController {

    @Autowired
    GenderService generoService;

    @PostMapping("/genders")
    public Gender addGender(@RequestBody Gender gender) {
        generoService.addGender(gender);
        return gender;
    }
}
