package com.kenzie.app;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/** This file was created by Kenzie Academy **/
/** This file was modified by Raymond Morales **/

public class CustomHttpClient {

    //implemented this method that takes URL and returns response
    public static String sendGET(String URLString) {
        // Start of GET request algorithm
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(URLString);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return httpResponse.body();
            } else {
                return String.format("GET request failed: %d status code received", statusCode);
            }

        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }

    }
}

