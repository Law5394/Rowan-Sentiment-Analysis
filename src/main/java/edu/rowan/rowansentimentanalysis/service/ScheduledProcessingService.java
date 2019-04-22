package edu.rowan.rowansentimentanalysis.service;

import edu.rowan.rowansentimentanalysis.repository.SentimentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

// TODO implement this
@Service
public class ScheduledProcessingService {

    @Autowired
    private DataProviderService dataProviderService;

    @Autowired
    @Qualifier("aws")
    private SentimentAnalysisService sentimentAnalysisService;

    @Autowired
    private SentimentRepository sentimentRepository;

    // how often the service will update
    // value comes from src/main/resources/application.properties sps.delay
    // TODO implement this
    @Scheduled(fixedDelayString = "${sps.delay}")
    public void runScheduledUpdate() {
        // tweets = this.dataProviderService.getNewTweetsIfThereAreAny();
        // analyzedTweets= this.analysisService().analyzeTweetsIfWeGotAnyNewOnes(tweets);
        // this.analyzedSentimentsRepo.storeNewAnalyzedSentiments(analyzedTweets);
        // save time updated also
    }
}
