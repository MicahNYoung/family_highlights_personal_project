package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

//    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAService");

    EntityManager em;

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

    @GetMapping("gethighlights/{famMemId}")
    public List<Highlight> displayAllHighlights(@PathVariable int famMemId) {
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
}
