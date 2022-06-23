package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.FamilyMember;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.Highlight;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyMemberRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.HighlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Micah Young
 */
@RestController
@RequestMapping("familymember")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private HighlightRepository highlightRepository;

    @PostMapping("add")
    public String addFamilyMember(@RequestBody FamilyMember familyMember) {
        familyMemberRepository.save(familyMember);
        return "New student is added.";
    }

//    @GetMapping("getfamily")
//    public List<FamilyMember> displayAllFamilyMembers(@RequestParam String familyId){
//
//        return familyMembers;
//    }

    @GetMapping("gethighlights")
    public List<Highlight> displayAllHighlights(@RequestParam int famMemId) {
        List<Highlight> highlights = highlightRepository.findAll();
        return highlights;
    }
}
