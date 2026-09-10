package com.eventTickettingSystem.data.models;

public enum Status {
    PENDING("Pending"),
    SUCCESSFUL("Successful"),
    FAILED("Failed");

    private final String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
