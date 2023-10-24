package com.example.dermicyclebackend.request;

/**
 * Represents a request for user registration in the DermiCycle system.
 */
public class RegisterRequest {
    private String emailAddress;
    private String firstName;
    private String skinCyclePreference;
    private String skinType;
    private String password;

    /**
     * Default constructor for the RegisterRequest class.
     */
    public RegisterRequest() {
    }

    /**
     * Parameterized constructor for the RegisterRequest class.
     *
     * @param emailAddress         The email address of the user.
     * @param firstName            The first name of the user.
     * @param skinCyclePreference  The skin cycle preference of the user.
     * @param skinType             The skin type of the user.
     * @param password             The password of the user.
     */
    public RegisterRequest(String emailAddress, String firstName, String skinCyclePreference, String skinType, String password) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.skinCyclePreference = skinCyclePreference;
        this.skinType = skinType;
        this.password = password;
    }

    /**
     * Get the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the email address of the user.
     *
     * @param emailAddress The email address of the user.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Get the first name of the user.
     *
     * @return The first name of the user.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of the user.
     *
     * @param firstName The first name of the user.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the skin cycle preference of the user.
     *
     * @return The skin cycle preference of the user.
     */
    public String getSkinCyclePreference() {
        return skinCyclePreference;
    }

    /**
     * Set the skin cycle preference of the user.
     *
     * @param skinCyclePreference The skin cycle preference of the user.
     */
    public void setSkinCyclePreference(String skinCyclePreference) {
        this.skinCyclePreference = skinCyclePreference;
    }

    /**
     * Get the skin type of the user.
     *
     * @return The skin type of the user.
     */
    public String getSkinType() {
        return skinType;
    }

    /**
     * Set the skin type of the user.
     *
     * @param skinType The skin type of the user.
     */
    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }

    /**
     * Get the password of the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user.
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}