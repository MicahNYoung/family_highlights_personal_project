package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.FamilyMember;
import com.family_highlights_personal_project.familyhighlights_personal_project.model.Highlight;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.FamilyMemberRepository;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.HighlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by Micah Young
 */
@RestController
@RequestMapping("highlight")
@CrossOrigin
public class HighlightController {

    @Autowired
    private HighlightRepository highlightRepository;

    @Autowired
    private FamilyMemberRepository familyMemberRepository;


    @PostMapping("/add/{familyMemberId}")
    public Highlight addHighlight(@RequestBody Highlight highlight, @PathVariable int familyMemberId) {
        FamilyMember familyMember = familyMemberRepository.findById(familyMemberId).get();
        highlight.assignFamilyMember(familyMember);
        return highlightRepository.save(highlight);
    }

    @DeleteMapping("/delete/{highlightId}")
    public String deleteHighlight(@PathVariable int highlightId) {

        Optional<Highlight> optHighlight = highlightRepository.findById(highlightId);
        if(optHighlight.isPresent()){
            Highlight highlight = (Highlight) optHighlight.get();
            highlightRepository.delete(highlight);
            return highlight.getId() + " has been deleted.";
        } else{
            return "No highlight find by id: " + highlightId;
        }
    }



}
