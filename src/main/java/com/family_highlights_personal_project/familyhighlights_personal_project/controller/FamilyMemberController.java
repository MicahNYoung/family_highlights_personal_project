package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.Family;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.FamilyMember;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.Highlight;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyMemberRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.HighlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
    public String addFamilyMember(@RequestBody FamilyMember familyMember, @RequestParam("familyId") String familyId) {
        Family family = familyRepository.findById(familyId).get();
        familyMember.assignFamily(family);
        familyMemberRepository.save(familyMember);
        return "New family member is added.";
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
//        Query q = em.createQuery("SELECT highlight from highlight WHERE family_member_id = 15");
//        q.setParameter("family_member_id", famMemId);
//        List<Highlight> highlights = q.getResultList();
        Optional<FamilyMember> optFamilyMember = familyMemberRepository.findById(famMemId);
        if(optFamilyMember.isPresent()){
            FamilyMember familyMember = (FamilyMember) optFamilyMember.get();
            List<Highlight> highlights = familyMember.getHighlights();
            return highlights;
        } else {
            return new ArrayList<>();
        }
    }

    @GetMapping("getfamily/{familyId}")

    public List<FamilyMember> displayFamily(@PathVariable String familyId) {
        Optional<Family> optFamily = familyRepository.findById(familyId);

        if(optFamily.isPresent()){
            Family family = (Family) optFamily.get();
            List<FamilyMember> familyMembers = family.getFamilyMembers();
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
