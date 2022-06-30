package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.Family;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.FamilyMember;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyMemberRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Micah Young
 */
@Controller

public class HomeController {
    FamilyRepository familyRepository;
    FamilyMemberRepository familyMemberRepository;

    @GetMapping("/login")
    public void displayLoginIn(){

    }

    @GetMapping("createaccount")
    public void displayCreateAccountPage(){

    }
    @PostMapping("createaccount")
    public String addFamilyMember(@RequestBody FamilyMember familyMember, @RequestParam("familyId") String familyId) {
        Family family = familyRepository.findById(familyId).get();
        familyMember.assignFamily(family);
        familyMemberRepository.save(familyMember);
        return "New student is added.";
    }
}
