package com.family_highlights_personal_project.familyhighlights_personal_project.model.dto;

/**
 * Created by Micah Young
 */
public class RegisterFormDTO extends LoginFormDTO{
    private String verifyPassword;

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
    }
}
