package com.learnon.model.dto;

public class ServiceCreateDTO {
    private String title;
    private String description;
    private String category;
    private int durationMinutes;
    private double price;
    private int capacity;
    // getters/setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
}
