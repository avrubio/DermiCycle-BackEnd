package com.example.dermicyclebackend.models;

import javax.persistence.*;

/**
 * Represents a user's profile in the DermiCycle system.
 */
@Entity
@Table(name = "UserProfile")
public class UserProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String skinCyclePreference;

    @Column
    private String skinType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    /**
     * Default constructor for the UserProfile class.
     */
    public UserProfile() {
    }

    /**
     * Parameterized constructor for the UserProfile class.
     *
     * @param firstName           The first name of the user.
     * @param skinCyclePreference The skin cycle preference of the user.
     * @param skinType            The skin type of the user.
     */
    public UserProfile(String firstName, String skinCyclePreference, String skinType) {
        this.firstName = firstName;
        this.skinCyclePreference = skinCyclePreference;
        this.skinType = skinType;
    }

    /**
     * Get the unique identifier of the user's profile.
     *
     * @return The user's profile's unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the user's profile.
     *
     * @param id The user's profile's unique identifier.
     */
    public void setId(Long id) {
        this.id = id;
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
     * Get the user associated with the user's profile.
     *
     * @return The user associated with the user's profile.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user associated with the user's profile.
     *
     * @param user The user associated with the user's profile.
     */
    public void setUser(User user) {
        this.user = user;
    }
}