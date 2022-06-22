package com.family_highlights_personal_project.familyhighlights_personal_project.model;



import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
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

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "This is not a valid email")
    @Size(min = 3, max = 100, message = "Email is too long")

    private String email;

    @NotBlank(message = "Mom's first name can not be blank")
    @Size(min = 3, max = 100, message = "Mom's firest name is too long")
    private String momFirst;

    @NotBlank(message = "Mom's last name can not be blank")
    @Size(min = 3, max = 100, message = "Mom's last name is too long")
    private String momLast;

    @NotBlank(message = "Dad's first name can not be blank")
    @Size(min = 3, max = 100, message = "Dad's firest name is too long")
    private String dadFirst;

    @NotBlank(message = "Dad's last name can not be blank")
    @Size(min = 3, max = 100, message = "Dad's last name is too long")
    private String dadLast;

    @Size(max=1000, message = "Your image URL is too long")
    private String imageUrl;

//    @OneToMany(mappedBy = "templates/familyMember")
//    private final List<Highlight> highlights = new ArrayList<>();
//
//    @ManyToOne
//    private Family family;

    public FamilyMember(){}

    /*public FamilyMember(String firstName, String lastName, String email, String momFirst, String momLast, String dadFirst, String dadLast, String imageUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.momFirst = momFirst;
        this.momLast = momLast;
        this.dadFirst = dadFirst;
        this.dadLast = dadLast;
        this.imageUrl = imageUrl;
    }*/

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMomFirst() {
        return momFirst;
    }

    public void setMomFirst(String momFirst) {
        this.momFirst = momFirst;
    }

    public String getMomLast() {
        return momLast;
    }

    public void setMomLast(String momLast) {
        this.momLast = momLast;
    }

    public String getDadFirst() {
        return dadFirst;
    }

    public void setDadFirst(String dadFirst) {
        this.dadFirst = dadFirst;
    }

    public String getDadLast() {
        return dadLast;
    }

    public void setDadLast(String dadLast) {
        this.dadLast = dadLast;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

//    public List<Highlight> getHighlights() {
//        return highlights;
//    }
//
//    public Family getFamily() {
//        return family;
//    }
//
//    public void setFamily(Family family) {
//        this.family = family;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(email, that.email) && Objects.equals(momFirst, that.momFirst) && Objects.equals(momLast, that.momLast) && Objects.equals(dadFirst, that.dadFirst) && Objects.equals(dadLast, that.dadLast) && Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, momFirst, momLast, dadFirst, dadLast, imageUrl);
    }

    @Override
    public String toString() {
        return "FamilyMember{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", momFirst='" + momFirst + '\'' +
                ", momLast='" + momLast + '\'' +
                ", dadFirst='" + dadFirst + '\'' +
                ", dadLast='" + dadLast + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
