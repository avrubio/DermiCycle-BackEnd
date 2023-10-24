package com.example.dermicyclebackend.response;

public class SingleProductResponseWithStageForUser {
    private Long stageId;
    private String stageName;
    private String stageDescription;
    private String productName;

    public SingleProductResponseWithStageForUser() {
    }

    public SingleProductResponseWithStageForUser(Long stageId, String stageName, String stageDescription, String productName) {
        this.stageId = stageId;
        this.stageName = stageName;
        this.stageDescription = stageDescription;
        this.productName = productName;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}