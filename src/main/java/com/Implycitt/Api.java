package com.Implycitt;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import java.net.URI;


public class Api {
  public static void main(String[] args) throws IOException {
    call();
  }

  public static void call() {
    String have = Globals.have;
    String want = Globals.want;
    int amount = Globals.amount;

    String url = String.format("https://currency-converter-by-api-ninjas.p.rapidapi.com/v1/convertcurrency?have=%s&want=%s&amount=%d", have, want, amount);
    String apiKey = Globals.getApi();

    HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create(url))
		.header("X-RapidAPI-Key", apiKey)
		.header("X-RapidAPI-Host", "currency-converter-by-api-ninjas.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
    HttpResponse<String> response;
    try {
      response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      System.out.println(response.body());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
