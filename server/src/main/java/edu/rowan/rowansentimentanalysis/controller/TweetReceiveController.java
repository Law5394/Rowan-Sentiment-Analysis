package edu.rowan.rowansentimentanalysis.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import edu.rowan.rowansentimentanalysis.model.RawTweet;
import edu.rowan.rowansentimentanalysis.model.Sentiment;
import edu.rowan.rowansentimentanalysis.repository.SentimentRepository;
import edu.rowan.rowansentimentanalysis.service.AnalyzedTweetService;
import edu.rowan.rowansentimentanalysis.service.SentimentAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/*
 * The Controller that provides our RESt api's core services
 *
 * */
@RestController
public class TweetReceiveController {

    private static final Logger log = LoggerFactory.getLogger(SentimentRepository.class);

    private SentimentAnalysisService sentimentAnalysisService;
    private AnalyzedTweetService analyzedTweetService;

    @Autowired
    public TweetReceiveController(@Qualifier("aws") SentimentAnalysisService sentimentAnalysisService,
                                  AnalyzedTweetService analyzedTweetService) {
        log.debug("Sentiment Controller instantiated");
        this.sentimentAnalysisService = sentimentAnalysisService;
        this.analyzedTweetService = analyzedTweetService;
    }

    @RequestMapping(value = "/tweet", method = POST,
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean getBySentiment(@RequestBody RawTweet rawTweet) {
        log.info("pos request: /api/tweet -> " + rawTweet.getText());

        final Sentiment sentiment = this.sentimentAnalysisService.analyzeSingleSentiment(Locale.ENGLISH, rawTweet.getText());

        log.info(String.format("Tweet Text: %s -> %s%n", rawTweet.getText(), sentiment.getSentiment()));

        this.analyzedTweetService.saveAnalyzedTweet(new AnalyzedTweet(rawTweet, sentiment));


        return true;
    }
}
