package com.learnon.model.dto;

import java.util.List;

public class StaffDTO extends StaffCreateDTO {
    private String id;
    private String providerId;
    // getters/setters
    public String getId(){return id;} public void setId(String id){this.id=id;}
    public String getProviderId(){return providerId;} public void setProviderId(String pid){this.providerId=pid;}
}
