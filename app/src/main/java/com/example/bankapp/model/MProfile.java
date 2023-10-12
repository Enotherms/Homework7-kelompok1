package com.example.bankapp.model;

public class MProfile {

    private int imageProfile;
    private String txtProfile;
    private String username;
    private String email;

    public MProfile(int imageProfile, String txtProfile) {
        this.imageProfile = imageProfile;
        this.txtProfile = txtProfile;
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(int imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getTxtProfile() {
        return txtProfile;
    }

    public void setTxtProfile(String txtProfile) {
        this.txtProfile = txtProfile;
    }
}
