package com.example.dermicyclebackend.response;

public class ProfileResponse {
    private String firstName;
    private String skinType;

    public ProfileResponse() {
    }

    public ProfileResponse(String firstName, String skinType) {
        this.firstName = firstName;
        this.skinType = skinType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }
}