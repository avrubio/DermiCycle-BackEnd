package com.example.dermicyclebackend.response;

/**
 * Represents a response containing information about a single product with its associated stage for a user in the DermiCycle system.
 */
public class SingleProductResponseWithStageForUser {
    private Long stageId;
    private String stageName;
    private String stageDescription;
    private String productName;

    /**
     * Default constructor for the SingleProductResponseWithStageForUser class.
     */
    public SingleProductResponseWithStageForUser() {
    }

    /**
     * Parameterized constructor for the SingleProductResponseWithStageForUser class.
     *
     * @param stageId         The unique identifier of the stage.
     * @param stageName       The name of the stage.
     * @param stageDescription The description of the stage.
     * @param productName      The name of the product associated with the stage.
     */
    public SingleProductResponseWithStageForUser(Long stageId, String stageName, String stageDescription, String productName) {
        this.stageId = stageId;
        this.stageName = stageName;
        this.stageDescription = stageDescription;
        this.productName = productName;
    }

    /**
     * Get the unique identifier of the stage.
     *
     * @return The unique identifier of the stage.
     */
    public Long getStageId() {
        return stageId;
    }

    /**
     * Set the unique identifier of the stage.
     *
     * @param stageId The unique identifier of the stage.
     */
    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    /**
     * Get the name of the stage.
     *
     * @return The name of the stage.
     */
    public String getStageName() {
        return stageName;
    }

    /**
     * Set the name of the stage.
     *
     * @param stageName The name of the stage.
     */
    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    /**
     * Get the description of the stage.
     *
     * @return The description of the stage.
     */
    public String getStageDescription() {
        return stageDescription;
    }

    /**
     * Set the description of the stage.
     *
     * @param stageDescription The description of the stage.
     */
    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }

    /**
     * Get the name of the product associated with the stage.
     *
     * @return The name of the product.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the name of the product associated with the stage.
     *
     * @param productName The name of the product.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }
}