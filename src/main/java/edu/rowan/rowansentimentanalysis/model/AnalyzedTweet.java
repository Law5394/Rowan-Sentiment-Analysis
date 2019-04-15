package edu.rowan.rowansentimentanalysis.model;


import lombok.Data;
/*
* Contains a tweet and the results of analysis on it
* */
@Data
public class AnalyzedTweet {
  private TweetData sourceTweet;
  private Sentiment sentimentResult;
}
