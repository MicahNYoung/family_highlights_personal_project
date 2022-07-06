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

    @GetMapping
    public String getFamilyId(@RequestParam int familyMemberId) {
        Optional optFamilyMember = familyMemberRepository.findById(familyMemberId);
        FamilyMember familyMember;
        if(optFamilyMember.isPresent()) {
            familyMember = (FamilyMember) optFamilyMember.get();
        } else {
            familyMember = null;
        }
        String familyId = familyMember.getFamily().getId();
        System.out.println("family Id is" + familyId);
        return familyId;
    }



}
