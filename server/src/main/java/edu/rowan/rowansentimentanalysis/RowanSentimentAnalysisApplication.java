package edu.rowan.rowansentimentanalysis;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
 * The Entry point of the application.
 * Instantiates services and injects dependencies
 * */
@SpringBootApplication
public class RowanSentimentAnalysisApplication {

    private static final Logger log = LoggerFactory.getLogger(RowanSentimentAnalysisApplication.class);

    public static void main(String[] args) {
        log.info("Starting application");
        SpringApplication.run(RowanSentimentAnalysisApplication.class, args);
    }

}
