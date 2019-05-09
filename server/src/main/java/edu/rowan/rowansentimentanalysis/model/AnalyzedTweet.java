package edu.rowan.rowansentimentanalysis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

/*
 * Contains a tweet and the results of analysis on it
 * */
@Entity
public class AnalyzedTweet {

    @Id
    private Long tweetId;

    private String date;
    private String text;
    private String userId;
    private String userScreenName;

    private Float posScore;
    private Float negScore;
    private Float neutralScore;

    @Enumerated(EnumType.STRING)
    private Sentiment.SentimentKind kind;

    protected AnalyzedTweet() {
    }

    public AnalyzedTweet(final RawTweet rawTweet, final Sentiment sentiment) {
        this.tweetId = rawTweet.getTweetId();
        this.date = rawTweet.getDate();
        this.text = rawTweet.getText();
        this.userId = rawTweet.getUserId();
        this.userScreenName = rawTweet.getUserScreenName();

        this.posScore = sentiment.getPositiveScore();
        this.negScore = sentiment.getNegativeScore();
        this.neutralScore = sentiment.getNeutralScore();
        this.kind = sentiment.getSentiment();
    }

}
