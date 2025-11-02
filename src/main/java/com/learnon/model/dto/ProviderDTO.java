package com.learnon.model.dto;

import java.util.List;

public class ProviderDTO {
    private String id;
    private String businessName;
    private String businessType;
    private List<String> serviceTypes;
    private boolean profileCompleted;
    private String createdAt;
    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }
    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }
    public List<String> getServiceTypes() { return serviceTypes; }
    public void setServiceTypes(List<String> serviceTypes) { this.serviceTypes = serviceTypes; }
    public boolean isProfileCompleted() { return profileCompleted; }
    public void setProfileCompleted(boolean profileCompleted) { this.profileCompleted = profileCompleted; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
