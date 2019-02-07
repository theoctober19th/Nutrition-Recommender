package com.ersathi.nutritionrecommender.models;

public class Food {
    private String name;
    private String thumbImageURI;
    private String description;
    private double calories;

    public Food() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbImageURI() {
        return thumbImageURI;
    }

    public void setThumbImageURI(String thumbImageURI) {
        this.thumbImageURI = thumbImageURI;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }
}
