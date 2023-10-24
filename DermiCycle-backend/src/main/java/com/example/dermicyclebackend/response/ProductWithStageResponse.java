package com.example.dermicyclebackend.response;
/**
 * Represents a response containing information about a product and its associated stage in the DermiCycle system.
 */
public class ProductWithStageResponse {
    private Long productId;
    private String productName;
    private String productDescription;
    private Long stageId;
    private String stageName;
    private String stageDescription;

    /**
     * Default constructor for the ProductWithStageResponse class.
     */
    public ProductWithStageResponse() {
    }

    /**
     * Parameterized constructor for the ProductWithStageResponse class.
     *
     * @param productId          The unique identifier of the product.
     * @param productName        The name of the product.
     * @param productDescription The description of the product.
     * @param stageId            The unique identifier of the stage to which the product belongs.
     * @param stageName          The name of the stage.
     * @param stageDescription   The description of the stage.
     */
    public ProductWithStageResponse(Long productId, String productName, String productDescription, Long stageId, String stageName, String stageDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.stageId = stageId;
        this.stageName = stageName;
        this.stageDescription = stageDescription;
    }

    /**
     * Get the unique identifier of the product.
     *
     * @return The unique identifier of the product.
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Set the unique identifier of the product.
     *
     * @param productId The unique identifier of the product.
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * Get the name of the product.
     *
     * @return The name of the product.
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the name of the product.
     *
     * @param productName The name of the product.
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Get the description of the product.
     *
     * @return The description of the product.
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * Set the description of the product.
     *
     * @param productDescription The description of the product.
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * Get the unique identifier of the stage to which the product belongs.
     *
     * @return The unique identifier of the stage.
     */
    public Long getStageId() {
        return stageId;
    }

    /**
     * Set the unique identifier of the stage to which the product belongs.
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
}