package com.family_highlights_personal_project.familyhighlights_personal_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

/**
 * Created by Micah Young
 */
@Entity
public class Highlight {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "The description of the highlight cannot be blank")
    private String description;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, fallbackPatterns = { "M/d/yy", "dd.MM.yyyy" })
//    @NotBlank(message = "The date cannot be bull")
//    private String date;
//
//    @NotBlank(message = "The imageURL cannot be blank")
//    private String imageURL;
//
//    @ManyToOne
//    private FamilyMember familyMember;

    public Highlight() {

    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public String getDate() {
//        return date;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
//    }
//
//    public String getImageURL() {
//        return imageURL;
//    }
//
//    public void setImageURL(String imageURL) {
//        this.imageURL = imageURL;
//    }
//
//    public FamilyMember getFamilyMember() {
//        return familyMember;
//    }
}
