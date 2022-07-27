package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.Family;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.FamilyMember;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.Highlight;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyMemberRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.HighlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Micah Young
 */
@RestController
@RequestMapping("familymember")
@CrossOrigin
public class FamilyMemberController {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private HighlightRepository highlightRepository;



//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAService");

    EntityManager em;

    @PostMapping("add")
    public ResponseEntity<String> addFamilyMember(@RequestBody @Valid FamilyMember familyMember, @RequestParam("familyId") String familyId, Errors errors) {
        Optional optFamily = familyRepository.findById(familyId);
        Family family;
        if(optFamily.isEmpty()) {
            return new ResponseEntity<>(
                    "Your family ID is invalid, Try Again",HttpStatus.BAD_REQUEST);
        }
        family = (Family) optFamily.get();
        familyMember.assignFamily(family);
        FamilyMember savedFamilyMember = familyMemberRepository.save(familyMember);
        return new ResponseEntity<>("Created", HttpStatus.CREATED);

    }

    @GetMapping("get")
    public FamilyMember getFamilyMember(@RequestParam String username) {

        Optional optFamilyMember = familyMemberRepository.findByUsername(username);
        FamilyMember familyMember;
        if(optFamilyMember.isPresent()) {
             familyMember = (FamilyMember) optFamilyMember.get();
        } else {
            familyMember = null;
        }
        System.out.println("family member is " + familyMember);
        return familyMember;

    }

    @GetMapping("gethighlights/{famMemId}")
    public List<Highlight> displayAllUserHighlights(@PathVariable int famMemId) {
        Optional<FamilyMember> optFamilyMember = familyMemberRepository.findById(famMemId);
        if(optFamilyMember.isPresent()){
            FamilyMember familyMember = (FamilyMember) optFamilyMember.get();
            List<Highlight> highlights = familyMember.getHighlights();
            return highlights;
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("getfamily/{familyMemberId}")

    public List<FamilyMember> displayFamily(@PathVariable int familyMemberId) {
        Optional<FamilyMember> optFamily = familyMemberRepository.findById(familyMemberId);

        if(optFamily.isPresent()){
            FamilyMember familyMember = (FamilyMember) optFamily.get();
            List<FamilyMember> familyMembers = familyMember.getFamily().getFamilyMembers();
            return familyMembers;
        } else {
            return new ArrayList<>();
        }
    }

    //Chose to put here because routes 
    @PostMapping("/add/addfamily")
    public String addFamily(@RequestBody Family family) {
        familyRepository.save(family);
        return "New family added";
    }


}
