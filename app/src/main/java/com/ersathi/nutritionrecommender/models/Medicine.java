package com.ersathi.nutritionrecommender.models;

import java.util.ArrayList;

public class Medicine {
    private int id;
    private String name;
    private int timesInADay;
    private int numberOfDays;
    private String reminderTimes;


    public Medicine() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTimesInADay() {
        return timesInADay;
    }

    public void setTimesInADay(int timesInADay) {
        this.timesInADay = timesInADay;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getReminderTimes() {
        return reminderTimes;
    }

    public void setReminderTimes(String reminderTimes) {
        this.reminderTimes = reminderTimes;
    }
}
