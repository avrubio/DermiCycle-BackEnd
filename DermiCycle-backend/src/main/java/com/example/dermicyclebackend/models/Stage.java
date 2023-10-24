package com.example.dermicyclebackend.models;


import javax.persistence.*;
/**
 * Represents a stage in the DermiCycle system.
 */

@Entity
@Table(name = "stages")
public class Stage {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String length;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
    /**
     * Default constructor for the Stage class.
     */
    public Stage() {
    }
    /**
     * Parameterized constructor for the Stage class.
     *
     * @param name        The name of the stage.
     * @param description The description of the stage.
     * @param length      The length of the stage.
     */
    public Stage(String name, String description, String length) {
        this.name = name;
        this.description = description;
        this.length = length;
    }
    /**
     * Get the unique identifier of the stage.
     *
     * @return The stage's unique identifier.
     */
    public Long getId() {
        return id;
    }
    /**
     * Set the unique identifier of the stage.
     *
     * @param id The stage's unique identifier.
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Get the name of the stage.
     *
     * @return The name of the stage.
     */

    public String getName() {
        return name;
    }

    /**
     * Set the name of the stage.
     *
     * @param name The name of the stage.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Get the description of the stage.
     *
     * @return The description of the stage.
     */
    public String getDescription() {
        return description;
    }
    /**
     * Set the description of the stage.
     *
     * @param description The description of the stage.
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Get the length of the stage.
     *
     * @return The length of the stage.
     */
    public String getLength() {
        return length;
    }
    /**
     * Set the length of the stage.
     *
     * @param length The length of the stage.
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * Get the product associated with the stage.
     *
     * @return The product associated with the stage.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the product associated with the stage.
     *
     * @param product The product associated with the stage.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Get the user associated with the stage.
     *
     * @return The user associated with the stage.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user associated with the stage.
     *
     * @param user The user associated with the stage.
     */
    public void setUser(User user) {
        this.user = user;
    }
}
