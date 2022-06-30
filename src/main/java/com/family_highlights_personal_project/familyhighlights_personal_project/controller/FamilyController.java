package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.Family;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Micah Young
 */
@RestController
@RequestMapping("family")
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;



}
