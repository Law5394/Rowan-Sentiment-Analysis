package edu.rowan.rowansentimentanalysis.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RawTweet implements Serializable {

    public RawTweet() {
    };

    @JsonProperty("tweet_id")
    private long tweetId;

    //@DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))

    @JsonProperty("date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;
    @JsonProperty("text")
    private String text;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_screen_name")
    private String userScreenName;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public RawTweet(long tweetId, LocalDateTime date, String text, Integer userId, String userScreenName) {
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

}
