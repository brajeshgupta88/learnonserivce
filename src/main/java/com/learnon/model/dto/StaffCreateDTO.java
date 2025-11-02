package com.learnon.model.dto;

import java.util.List;

public class StaffCreateDTO {
    private String name;
    private String email;
    private String mobile;
    private String role;
    private List<String> expertise;
    // getters/setters
    public String getName(){return name;} public void setName(String n){this.name=n;}
    public String getEmail(){return email;} public void setEmail(String e){this.email=e;}
    public String getMobile(){return mobile;} public void setMobile(String m){this.mobile=m;}
    public String getRole(){return role;} public void setRole(String r){this.role=r;}
    public List<String> getExpertise(){return expertise;} public void setExpertise(List<String> x){this.expertise=x;}
}
