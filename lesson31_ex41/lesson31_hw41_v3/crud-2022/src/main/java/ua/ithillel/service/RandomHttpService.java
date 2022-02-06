package ua.ithillel.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RandomHttpService {

    public Integer getNumber(int min, int max) {
        HttpRequest request = null;
        Integer number = null;
        String curl = "http://www.randomnumberapi.com/api/v1.0/random?min=" + min + "&max=" + max + "&count=1";
        try {
            request = HttpRequest.newBuilder()
                    .uri(new URI(curl))
                    .GET()
                    .build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String responseBody = response.body();
            number = Integer.parseInt(responseBody.substring(1, responseBody.length() - 1));
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return number;
    }
}
