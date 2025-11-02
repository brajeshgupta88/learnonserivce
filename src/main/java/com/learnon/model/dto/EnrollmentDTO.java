package com.learnon.model.dto;

import java.util.Map;

public class EnrollmentDTO {
    private String id; private String batchId; private String customerId; private Map<String,Object> learner; private String status; private boolean attended; private String createdAt;
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getBatchId(){return batchId;} public void setBatchId(String b){this.batchId=b;}
    public String getCustomerId(){return customerId;} public void setCustomerId(String c){this.customerId=c;}
    public Map<String,Object> getLearner(){return learner;} public void setLearner(Map<String,Object>l){this.learner=l;}
    public String getStatus(){return status;} public void setStatus(String s){this.status=s;}
    public boolean isAttended(){return attended;} public void setAttended(boolean a){this.attended=a;}
    public String getCreatedAt(){return createdAt;} public void setCreatedAt(String c){this.createdAt=c;}
}
