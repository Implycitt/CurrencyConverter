package com.Implycitt;

import io.github.cdimascio.dotenv.Dotenv;

public class Globals {
  
  public static int amount = 5000;
  public static String have = "USD";
  public static String want = "EUR";
  
  public static String getApi() {
    Dotenv dotenv = Dotenv.load();

    String apiKey = dotenv.get("API_KEY");
    return apiKey;
  }
}
