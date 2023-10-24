package com.example.dermicyclebackend.models;


import javax.persistence.*;

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

    public UserProfile() {
    }

    public UserProfile(String firstName, String skinCyclePreference, String skinType) {
        this.firstName = firstName;
        this.skinCyclePreference = skinCyclePreference;
        this.skinType = skinType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}