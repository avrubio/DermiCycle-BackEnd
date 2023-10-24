package com.example.dermicyclebackend.request;

/**
 * Represents a request for creating a product with a stage in the DermiCycle system.
 */
public class ProductWithStage {
    private String name;
    private String directions;
    private Long stageId;

    /**
     * Default constructor for the ProductWithStage class.
     */
    public ProductWithStage() {
    }

    /**
     * Parameterized constructor for the ProductWithStage class.
     *
     * @param name       The name of the product.
     * @param directions The directions for using the product.
     * @param stageId    The ID of the stage to which the product belongs.
     */
    public ProductWithStage(String name, String directions, Long stageId) {
        this.name = name;
        this.directions = directions;
        this.stageId = stageId;
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
     * Get the ID of the stage to which the product belongs.
     *
     * @return The ID of the stage.
     */
    public Long getStageId() {
        return stageId;
    }

    /**
     * Set the ID of the stage to which the product belongs.
     *
     * @param stageId The ID of the stage.
     */
    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }
}