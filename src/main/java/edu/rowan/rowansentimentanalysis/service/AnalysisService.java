package edu.rowan.rowansentimentanalysis.service;

import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import edu.rowan.rowansentimentanalysis.model.TweetData;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * A service that provides sentiment analysis
 * - Should accept data and call relevant 3rd party api's
 * to conduct sentiment analysis on the data
 * */
// TODO implement this
@Service
public class AnalysisService {

  // TODO implement this
  public List<AnalyzedTweet> analyzeTweets(TweetData... tweets) {
    return null;
  }
}
