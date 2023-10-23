package com.example.dermicyclebackend.response;

public class ProductWithStageResponse {
    private Long productId;
    private String productName;
    private String productDescription;
    private Long stageId;
    private String stageName;
    private String stageDescription;

    public ProductWithStageResponse() {
    }

    public ProductWithStageResponse(Long productId, String productName, String productDescription, Long stageId, String stageName, String stageDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.stageId = stageId;
        this.stageName = stageName;
        this.stageDescription = stageDescription;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getStageDescription() {
        return stageDescription;
    }

    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }
}
