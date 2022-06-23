package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.FamilyMember;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Micah Young
 */
@RestController
@RequestMapping("familymember")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @PostMapping("add")
    public String addFamilyMember(@RequestBody FamilyMember familyMember) {
        familyMemberRepository.save(familyMember);
        return "New student is added.";
    }

}
