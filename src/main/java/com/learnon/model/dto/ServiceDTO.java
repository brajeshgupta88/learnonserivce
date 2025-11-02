package com.learnon.model.dto;

public class ServiceDTO extends ServiceCreateDTO {
    private String id;
    private String providerId;
    private String createdAt;
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getProviderId() { return providerId; }
    public void setProviderId(String providerId) { this.providerId = providerId; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
