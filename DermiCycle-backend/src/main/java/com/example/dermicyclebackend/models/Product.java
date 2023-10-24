package com.example.dermicyclebackend.models;

import com.example.dermicyclebackend.request.ProductWithStage;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a product in the DermiCycle system.
 */
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String directions;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stage_id", referencedColumnName = "id")
    private Stage stage;

    /**
     * Default constructor for the Product class.
     */
    public Product() {
    }

    /**
     * Parameterized constructor for the Product class.
     *
     * @param id         The unique identifier of the product.
     * @param name       The name of the product.
     * @param directions The directions for using the product.
     */
    public Product(Long id, String name, String directions) {
        this.id = id;
        this.name = name;
        this.directions = directions;
    }

    /**
     * Get the unique identifier of the product.
     *
     * @return The product's unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the unique identifier of the product.
     *
     * @param id The product's unique identifier.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Get the name of the product.
     *
     * @return The name of the product.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     *
     * @param name The name of the product.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the directions for using the product.
     *
     * @return The directions for using the product.
     */
    public String getDirections() {
        return directions;
    }

    /**
     * Set the directions for using the product.
     *
     * @param directions The directions for using the product.
     */
    public void setDirections(String directions) {
        this.directions = directions;
    }

    /**
     * Get the user associated with the product.
     *
     * @return The user associated with the product.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user associated with the product.
     *
     * @param user The user associated with the product.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the stage to which the product belongs.
     *
     * @return The stage to which the product belongs.
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Set the stage to which the product belongs.
     *
     * @param stage The stage to which the product belongs.
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Get a string representation of the product, including its ID, name, directions, user, and stage.
     *
     * @return A string representation of the product.
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", directions='" + directions + '\'' +
                ", user=" + user +
                ", stage=" + stage +
                '}';
    }
}