package com.family_highlights_personal_project.familyhighlights_personal_project.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Micah Young
 */


@Entity
public class FamilyMember {
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "First Name can not be blank")
    @Size(min = 3, max = 100, message = "First Name is too long")
    private String firstName;

    @NotBlank(message = "Last Name can not be blank")
    @Size(min = 3, max = 100, message = "Last Name is too long")
    private String lastName;
    @Column(unique = true)
    @NotBlank(message = "Username cannot be blank")
    @Size(min = 3, max = 100, message = "Username is too long")
    private String username;

    @NotBlank(message = "Password can not be blank")
    @Size(min = 3, max = 100, message = "Password is too long")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "This is not a valid email")
    @Size(min = 3, max = 100, message = "Email is too long")

    private String email;

    @NotBlank(message = "Mom's first name can not be blank")
    @Size(min = 3, max = 100, message = "Mom's first name is too long")
    private String momFirstName;

    @NotBlank(message = "Mom's last name can not be blank")
    @Size(min = 3, max = 100, message = "Mom's last name is too long")
    private String momLastName;

    @NotBlank(message = "Dad's first name can not be blank")
    @Size(min = 3, max = 100, message = "Dad's firest name is too long")
    private String dadFirstName;

    @NotBlank(message = "Dad's last name can not be blank")
    @Size(min = 3, max = 100, message = "Dad's last name is too long")
    private String dadLastName;

    @Size(max=1000, message = "Your image URL is too long")
    private String imageUrl;


    @OneToMany(mappedBy = "familyMember",fetch = FetchType.EAGER)
    private final List<Highlight> highlights = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    private Family family;

    public FamilyMember(){}

    public FamilyMember(String firstName, String lastName, String username, String password, String email, String momFirstName, String momLastName, String dadFirstName, String dadLastName, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.momFirstName = momFirstName;
        this.momLastName = momLastName;
        this.dadFirstName = dadFirstName;
        this.dadLastName = dadLastName;
        this.imageUrl = imageUrl;
    }



    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMomFirstName() {
        return momFirstName;
    }

    public void setMomFirstName(String momFirstName) {
        this.momFirstName = momFirstName;
    }

    public String getMomLastName() {
        return momLastName;
    }

    public void setMomLastName(String momLastName) {
        this.momLastName = momLastName;
    }

    public String getDadFirstName() {
        return dadFirstName;
    }

    public void setDadFirstName(String dadFirstName) {
        this.dadFirstName = dadFirstName;
    }

    public String getDadLastName() {
        return dadLastName;
    }

    public void setDadLastName(String dadLastName) {
        this.dadLastName = dadLastName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Highlight> getHighlights() {
        return highlights;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void assignFamily(Family family) {
        this.family= family;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, momFirstName, momLastName, dadFirstName, dadLastName, imageUrl);
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", momFirst='" + momFirstName + '\'' +
                ", momLast='" + momLastName + '\'' +
                ", dadFirst='" + dadFirstName + '\'' +
                ", dadLast='" + dadLastName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
