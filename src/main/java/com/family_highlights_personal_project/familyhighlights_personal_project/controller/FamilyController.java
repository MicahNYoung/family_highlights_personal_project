package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.Family;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.FamilyMember;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyMemberRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Micah Young
 */
@RestController
@RequestMapping("family")
@CrossOrigin
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @GetMapping("add")
    public String addNewFamily(@RequestParam String familyName) {
        Family family = new Family(familyName);
        familyRepository.save(family);
        return family.getId();
    }
    @GetMapping("get")
    public String getFamilyId(@RequestParam int familyMemberId) {
        Optional optFamilyMember = familyMemberRepository.findById(familyMemberId);
        FamilyMember familyMember;
        if(optFamilyMember.isPresent()) {
            familyMember = (FamilyMember) optFamilyMember.get();
        } else {
            familyMember = null;
        }
        String familyId = familyMember.getFamily().getId();
        return familyId;
    }



}
