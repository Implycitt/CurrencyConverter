package org.example;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
      File write = new File("data.json");
      write.createNewFile();
      FileWriter writer = new FileWriter("data.json");
      writer.write(String.valueOf(response.body()));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static Object getFinalAmount() {
    double finalAmount = 0.0;
    JSONParser parser = new JSONParser();
    try {
        Object obj = parser.parse(new FileReader("data.json"));
        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get("new_amount");

    } catch (Exception e) {
      e.printStackTrace();
    }
    return (Object) finalAmount;
  }
}