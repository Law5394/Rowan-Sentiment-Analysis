package edu.rowan.rowansentimentanalysis.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import edu.rowan.rowansentimentanalysis.repository.SentimentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/*
 * The Controller that provides our RESt api's core services
 *
 * */
@RestController
public class TweetReceiveController {

    private static final Logger log = LoggerFactory.getLogger(SentimentRepository.class);
    private SentimentRepository sentimentRepository;

    @Autowired
    public TweetReceiveController(SentimentRepository sentRepo) {
        log.debug("Sentiment Controller instantiated");
        this.sentimentRepository = sentRepo;
    }


    @RequestMapping(value = "/tweet",
            method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AnalyzedTweet> getBySentiment(@RequestBody RawTweet rawTweet) {
        log.info("pos request: /api/tweet -> " + rawTweet.text);
        return null;
    }

    class RawTweet {
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
    }
}
