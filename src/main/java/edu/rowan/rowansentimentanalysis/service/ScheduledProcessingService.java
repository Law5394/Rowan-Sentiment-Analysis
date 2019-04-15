package edu.rowan.rowansentimentanalysis.service;

import edu.rowan.rowansentimentanalysis.repository.SentimentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

// TODO implement this
@Service
public class ScheduledProcessingService {

  private DataProviderService dataProviderService;
  private AnalysisService analysisService;
  private SentimentRepository sentimentRepository;

  @Autowired
  public ScheduledProcessingService(DataProviderService dataProviderService,
                                    AnalysisService analysisService,
                                    SentimentRepository sentimentRepository) {
    this.dataProviderService = dataProviderService;
    this.analysisService = analysisService;
    this.sentimentRepository = sentimentRepository;
  }

  // how oftken the service will update
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
