package com.example.assignment2java;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnector {

    private static final String APOD_URL = "https://api.nasa.gov/planetary/apod";
    private static final String API_KEY = "8udXzQDIm3c7dmYHthqvMlALMRZwP11gcTzlONTL";

    // Retrieves APOD data for the given date from the NASA API
    public static Apod getApod(String date) throws IOException {
        URL url = new URL(APOD_URL + "?api_key=" + API_KEY + "&date=" + date);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        Gson gson = new Gson(); // Converts JSON response to Apod object using Gson
        return gson.fromJson(new InputStreamReader(conn.getInputStream()), Apod.class);
    }
}