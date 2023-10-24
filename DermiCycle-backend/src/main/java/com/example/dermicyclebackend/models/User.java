package com.example.dermicyclebackend.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

/**
 * Represents a user in the DermiCycle system.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String emailAddress;

    @Column
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @OneToMany(mappedBy = "user")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Product> productList;

    /**
     * Default constructor for the User class.
     */
    public User() {
    }

    /**
     * Parameterized constructor for the User class.
     *
     * @param id          The unique identifier of the user.
     * @param emailAddress The email address of the user.
     * @param password    The password of the user.
     */
    public User(Long id, String emailAddress, String password) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    /**
     * Get the list of products associated with the user.
     *
     * @return The list of products associated with the user.
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * Set the list of products associated with the user.
     *
     * @param productList The list of products associated with the user.
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * Get the unique identifier of the user.
     *
     * @return The user's unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the user.
     *
     * @param id The user's unique identifier.
     */
    public void setId(Long id) {
        this.id = id;
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
     * Get the password of the user.
     *
     * @return The password of the user (write-only, not included in JSON serialization).
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the password of the user (write-only, not included in JSON serialization).
     *
     * @param password The password of the user.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get a string representation of the user, including their ID, email address, and password (excluded from serialization).
     *
     * @return A string representation of the user.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}