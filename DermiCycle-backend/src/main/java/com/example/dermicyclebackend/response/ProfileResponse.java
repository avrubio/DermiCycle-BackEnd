package com.example.dermicyclebackend.response;

/**
 * Represents a response containing user profile information in the DermiCycle system.
 */
public class ProfileResponse {
    private String firstName;
    private String skinType;

    /**
     * Default constructor for the ProfileResponse class.
     */
    public ProfileResponse() {
    }

    /**
     * Parameterized constructor for the ProfileResponse class.
     *
     * @param firstName The first name of the user.
     * @param skinType  The skin type of the user.
     */
    public ProfileResponse(String firstName, String skinType) {
        this.firstName = firstName;
        this.skinType = skinType;
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
}