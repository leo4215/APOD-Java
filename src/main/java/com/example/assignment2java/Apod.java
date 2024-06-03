package com.example.assignment2java;

// Represents the entity, an Astronomy Picture of the Day (APOD) retrieved from the NASA API
public class Apod {
    public String title;
    public String date;
    public String explanation;
    public String url;

    // Getter methods for the title, date, explanation and url of the APOD
    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getUrl() {
        return url;
    }
}
