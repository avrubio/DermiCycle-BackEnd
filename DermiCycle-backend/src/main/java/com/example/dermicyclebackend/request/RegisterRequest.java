package com.example.dermicyclebackend.request;

public class RegisterRequest {
    private String emailAddress;
    private String firstName;
    private String skinCyclePreference;
    private String skinType;
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(String emailAddress, String firstName, String skinCyclePreference, String skinType, String password) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.skinCyclePreference = skinCyclePreference;
        this.skinType = skinType;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSkinCyclePreference() {
        return skinCyclePreference;
    }

    public void setSkinCyclePreference(String skinCyclePreference) {
        this.skinCyclePreference = skinCyclePreference;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}