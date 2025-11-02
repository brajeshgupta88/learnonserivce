package com.learnon.model.dto;

public class ProviderMetricsDTO {
    private String providerId; private int totalEnrollments; private double csatScore;
    public String getProviderId(){return providerId;} public void setProviderId(String p){this.providerId=p;}
    public int getTotalEnrollments(){return totalEnrollments;} public void setTotalEnrollments(int t){this.totalEnrollments=t;}
    public double getCsatScore(){return csatScore;} public void setCsatScore(double s){this.csatScore=s;}
}
