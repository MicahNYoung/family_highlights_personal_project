package com.family_highlights_personal_project.familyhighlights_personal_project.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Created by Micah Young
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String username;

    @NotNull
    private String pwHash;

//    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() {}

    public User(String username, String password) {
        this.username = username;
//        this.pwHash = encoder.encode(password);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
//
//    public boolean isMatchingPassword(String password) {
//        return encoder.matches(password, pwHash);
//    }
}
