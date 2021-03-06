package com.family_highlights_personal_project.familyhighlights_personal_project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Micah Young
 */
@Entity
public class Family {
    @Id
    String id = UUID.randomUUID().toString();

    private String name;


    @OneToMany(mappedBy = "family", fetch = FetchType.EAGER)
    private final List<FamilyMember> familyMembers = new ArrayList<>();



    public Family() {}

    public Family(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public List<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }

}
