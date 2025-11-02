package com.learnon.model.dto;

import java.util.List;

public class BatchDTO extends BatchCreateDTO {
    private String id; private String providerId; private String createdAt;
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getProviderId(){return providerId;} public void setProviderId(String p){this.providerId=p;}
    public String getCreatedAt(){return createdAt;} public void setCreatedAt(String c){this.createdAt=c;}
}
