package edu.rowan.rowansentimentanalysis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class RawTweet implements Serializable {

    public RawTweet() {
    };

    @JsonProperty("tweet_id")
    private long tweetId;
    @JsonProperty("date")
    private String date;
    @JsonProperty("text")
    private String text;
    @JsonProperty("user_id")
    private String userId;
    @JsonProperty("user_screen_name")
    private String userScreenName;

    public RawTweet(long tweetId, String date, String text, String userId, String userScreenName) {
        this.tweetId = tweetId;
        this.date = date;
        this.text = text;
        this.userId = userId;
        this.userScreenName = userScreenName;
    }

    public long getTweetId() {
        return tweetId;
    }

    public void setTweetId(long tweetId) {
        this.tweetId = tweetId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }
}
