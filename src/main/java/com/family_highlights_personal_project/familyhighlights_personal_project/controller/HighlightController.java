package com.family_highlights_personal_project.familyhighlights_personal_project.controller;

import com.family_highlights_personal_project.familyhighlights_personal_project.model.Highlight;
import com.family_highlights_personal_project.familyhighlights_personal_project.repository.HighlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Micah Young
 */
@RestController
@RequestMapping("highlight")
public class HighlightController {

    @Autowired
    private HighlightRepository highlightRepository;

    @PostMapping("add")
    public String addHighlight(@RequestBody Highlight highlight) {
        highlightRepository.save(highlight);

        return "New highlight added.";
    }
}
