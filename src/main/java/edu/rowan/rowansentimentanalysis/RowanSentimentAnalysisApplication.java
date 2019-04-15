package edu.rowan.rowansentimentanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
 * The Entry point of the application.
 * Instantiates services and injects dependencies
 * */
@EnableScheduling
@SpringBootApplication
public class RowanSentimentAnalysisApplication {

  public static void main(String[] args) {
    SpringApplication.run(RowanSentimentAnalysisApplication.class, args);
  }

}
