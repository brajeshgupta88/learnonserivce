package com.learnon.model.dto;

public class CustomerRegistrationDTO {
    private String email; private String firstName; private String lastName; private String country; private String password; private String mobile;
    public String getEmail(){return email;} public void setEmail(String e){this.email=e;}
    public String getFirstName(){return firstName;} public void setFirstName(String f){this.firstName=f;}
    public String getLastName(){return lastName;} public void setLastName(String l){this.lastName=l;}
    public String getCountry(){return country;} public void setCountry(String c){this.country=c;}
    public String getPassword(){return password;} public void setPassword(String p){this.password=p;}
    public String getMobile(){return mobile;} public void setMobile(String m){this.mobile=m;}
}
