package edu.rowan.rowansentimentanalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * The Entry point of the application.
 * Instantiates services and injects dependencies
 * */
@EnableScheduling
@SpringBootApplication
public class RowanSentimentAnalysisApplication {

    private static final Logger log = LoggerFactory.getLogger(RowanSentimentAnalysisApplication.class);

    public static void main(String[] args) {
        log.info("Starting application");
        SpringApplication.run(RowanSentimentAnalysisApplication.class, args);
    }

}
