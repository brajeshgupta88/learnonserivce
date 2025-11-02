package com.learnon.model.dto;

import java.util.List;

public class BatchCreateDTO {
    private List<String> days;
    private String time;
    private String startDate;
    private String endDate;
    private boolean isRecurring;
    private String serviceId;
    private String staffId;
    private String locationId;
    private Integer capacity;
    // getters/setters
    public List<String> getDays(){return days;} public void setDays(List<String>d){this.days=d;}
    public String getTime(){return time;} public void setTime(String t){this.time=t;}
    public String getStartDate(){return startDate;} public void setStartDate(String s){this.startDate=s;}
    public String getEndDate(){return endDate;} public void setEndDate(String e){this.endDate=e;}
    public boolean isRecurring(){return isRecurring;} public void setRecurring(boolean r){this.isRecurring=r;}
    public String getServiceId(){return serviceId;} public void setServiceId(String s){this.serviceId=s;}
    public String getStaffId(){return staffId;} public void setStaffId(String s){this.staffId=s;}
    public String getLocationId(){return locationId;} public void setLocationId(String l){this.locationId=l;}
    public Integer getCapacity(){return capacity;} public void setCapacity(Integer c){this.capacity=c;}
}
