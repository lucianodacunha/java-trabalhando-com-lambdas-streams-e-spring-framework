package io.github.lucianodacunha.screenmatch.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumerAPI {

    public String getData(String url){

        HttpClient client = HttpClient.newHttpClient();
        URI endpoint = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(endpoint)
                .build();

        HttpResponse<String> response = null;

        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }


}


