package com.learnon.model.dto;

import java.util.Map;

public class EnrollmentCreateDTO {
    private String customerId;
    private Map<String,Object> learner;
    private String paymentIntentId;
    private String notes;
    // getters/setters
    public String getCustomerId(){return customerId;} public void setCustomerId(String c){this.customerId=c;}
    public Map<String,Object> getLearner(){return learner;} public void setLearner(Map<String,Object>l){this.learner=l;}
    public String getPaymentIntentId(){return paymentIntentId;} public void setPaymentIntentId(String p){this.paymentIntentId=p;}
    public String getNotes(){return notes;} public void setNotes(String n){this.notes=n;}
}
