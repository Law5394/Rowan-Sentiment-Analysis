package edu.rowan.rowansentimentanalysis.controller;

import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import edu.rowan.rowansentimentanalysis.repository.SentimentRepository;
import edu.rowan.rowansentimentanalysis.service.ScheduledProcessingService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * The Controller that provides our RESt api's core services
 *
 * */
@Log
@RestController
public class SentimentController {

  private ScheduledProcessingService processingService;
  private SentimentRepository sentimentRepository;

  // not sure which way we should do this
  // we can call Repository directly to get Data to serve request
  // or we can call ScheduledProcessingService which will call the database
  // or we can make an new Service all together to call the database;
  @Autowired
  public SentimentController(ScheduledProcessingService processingService,
                             SentimentRepository sentRepo) {
    this.processingService = processingService;
    this.sentimentRepository = sentRepo;
  }

  // return some happy tweets
  // can parse out a variable from the path and do different things based on that
  // TODO implement this
  @RequestMapping(value = "/api/bySentiment/{tweetSentiment}", method = RequestMethod.GET, produces = "application/json")
  public List<AnalyzedTweet> getBySentiment(@PathVariable("tweetSentiment") String tweetSentiment) {
    // if tweetSentiment == happy
    //return happyTweets();
    // etc
    return null;
  }

  // TODO implement this
  @RequestMapping(value = "/api/byMonth/{monthName}", method = RequestMethod.GET, produces = "application/json")
  public List<AnalyzedTweet> getFromMonth(@PathVariable("monthName") String monthName) {
    return null;
  }

  // can also get regular query params
  // so if they typed http://$ADDRESS:$PORT/recentTweets?count=20
  // u could get the 20 like u would expect and give them 20 tweets
  // TODO implement this
  @PostMapping("/api/recentTweets")
  @ResponseBody
  public String addFoo(@RequestParam(name = "count") String tweetCount) {
    // return mostRecentTweets(tweetCount);
    return null;
  }

  // TODO think of and add a bunch more endpoints for this
}
