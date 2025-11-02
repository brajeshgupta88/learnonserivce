package com.learnon.model.dto;

import java.util.List;

public class ProviderOnboardingDTO {
    private Integer wizardStep;
    private String businessType;
    private List<String> serviceTypes;
    private String businessName;
    // getters/setters
    public Integer getWizardStep() { return wizardStep; }
    public void setWizardStep(Integer wizardStep) { this.wizardStep = wizardStep; }
    public String getBusinessType() { return businessType; }
    public void setBusinessType(String businessType) { this.businessType = businessType; }
    public List<String> getServiceTypes() { return serviceTypes; }
    public void setServiceTypes(List<String> serviceTypes) { this.serviceTypes = serviceTypes; }
    public String getBusinessName() { return businessName; }
    public void setBusinessName(String businessName) { this.businessName = businessName; }
}
