package edu.rowan.rowansentimentanalysis.model;

import edu.rowan.rowansentimentanalysis.SentimentKind;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/*
 * Contains a tweet and the results of analysis on it
 * */
@Entity
public class AnalyzedTweet implements Serializable {

    @Id
    private Long tweetId;

    @Basic
    private LocalDateTime date;
    private String text;
    private Integer userId;
    private String userScreenName;

    private Float posScore;
    private Float negScore;
    private Float neutralScore;

    @Enumerated(EnumType.STRING)
    private SentimentKind kind;

    protected AnalyzedTweet() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "AnalyzedTweet{" +
                "tweetId=" + tweetId +
                ", date='" + date + '\'' +
                ", text='" + text + '\'' +
                ", userId='" + userId + '\'' +
                ", userScreenName='" + userScreenName + '\'' +
                ", posScore=" + posScore +
                ", negScore=" + negScore +
                ", neutralScore=" + neutralScore +
                ", kind=" + kind +
                '}';
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    public Float getPosScore() {
        return posScore;
    }

    public void setPosScore(Float posScore) {
        this.posScore = posScore;
    }

    public Float getNegScore() {
        return negScore;
    }

    public void setNegScore(Float negScore) {
        this.negScore = negScore;
    }

    public Float getNeutralScore() {
        return neutralScore;
    }

    public void setNeutralScore(Float neutralScore) {
        this.neutralScore = neutralScore;
    }

    public SentimentKind getKind() {
        return kind;
    }

    public void setKind(SentimentKind kind) {
        this.kind = kind;
    }

}
