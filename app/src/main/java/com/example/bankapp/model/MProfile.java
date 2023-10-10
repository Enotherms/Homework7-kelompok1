package com.example.bankapp.model;

public class MProfile {

    private int imageProfile;
    private String txtProfile;

    public MProfile(int imageProfile, String txtProfile) {
        this.imageProfile = imageProfile;
        this.txtProfile = txtProfile;
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
