package com.Implycitt;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

import javax.swing.JTextField;

public class Globals {
  
  public static int amount = 5000;
  public static String have = "USD";
  public static String want = "EUR";
  public static String apiKey = "";
  public static String[] supportedCurrencies = {"USD", "EUR", "CNY", "CHF", "AUD", "PLN", "TRY", "CAD", "JPY", "GBP", "NZD", "KRW", "DKK", "HKD"};
  
  public static void setApi() {
    try {
      File file = new File(".env");
      Scanner reader = new Scanner(file);
      while (reader.hasNextLine()) {
        apiKey = reader.nextLine();
      }
      reader.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void setAmount(int am) {
    amount = am;
  }

  public static void setHave(String h) {
    have = h;
  }

  public static void setWant(String w) {
    want = w;
  }

  public static String getApi() {
    setApi();
    return apiKey; 
  }

  public static int getAmount() {
    return amount;
  }

  public static String getHave() {
    return have;
  }

  public static String getWant() {
    return want;
  }

  public static String[] getSupported() {
    return supportedCurrencies;
  }
}
