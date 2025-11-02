package com.learnon.model.dto;

public class CustomerDTO {
    private String id; private String email; private String firstName; private String lastName; private String country; private String mobile; private String createdAt;
    public String getId(){return id;} public void setId(String i){this.id=i;}
    public String getEmail(){return email;} public void setEmail(String e){this.email=e;}
    public String getFirstName(){return firstName;} public void setFirstName(String f){this.firstName=f;}
    public String getLastName(){return lastName;} public void setLastName(String l){this.lastName=l;}
    public String getCountry(){return country;} public void setCountry(String c){this.country=c;}
    public String getMobile(){return mobile;} public void setMobile(String m){this.mobile=m;}
    public String getCreatedAt(){return createdAt;} public void setCreatedAt(String c){this.createdAt=c;}
}
