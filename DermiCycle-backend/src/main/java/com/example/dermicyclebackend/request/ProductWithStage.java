package com.example.dermicyclebackend.request;

public class ProductWithStage {
    private String name;
    private String directions;
    private Long stageId;

    public ProductWithStage() {
    }

    public ProductWithStage(String name, String directions, Long stageId) {
        this.name = name;
        this.directions = directions;
        this.stageId = stageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public Long getStageId() {
        return stageId;
    }

    public void setStageId(Long stageId) {
        this.stageId = stageId;
    }
}
