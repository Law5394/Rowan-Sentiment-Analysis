package edu.rowan.rowansentimentanalysis.controller;

import edu.rowan.rowansentimentanalysis.SentimentKind;
import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import edu.rowan.rowansentimentanalysis.model.RawTweet;
import edu.rowan.rowansentimentanalysis.model.Sentiment;
import edu.rowan.rowansentimentanalysis.service.AnalyzedTweetService;
import edu.rowan.rowansentimentanalysis.service.SentimentAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/*
 * The Controller that provides our RESt api's core services
 *
 * */
@RestController
@RequestMapping("/tweets")
public class TweetController {

    private static final Logger log = LoggerFactory.getLogger(TweetController.class);
    private SentimentAnalysisService sentimentAnalysisService;
    private AnalyzedTweetService analyzedTweetService;

    @Autowired
    public TweetController(@Qualifier("aws") SentimentAnalysisService sentimentAnalysisService,
                           AnalyzedTweetService analyzedTweetService) {
        log.debug("Sentiment Controller instantiated");
        this.sentimentAnalysisService = sentimentAnalysisService;
        this.analyzedTweetService = analyzedTweetService;
    }

    @GetMapping("")
    public @ResponseBody
    Collection<AnalyzedTweet> getTweets(@RequestParam(name = "kind") Optional<SentimentKind> kind,
                                        @RequestParam(name = "count") Optional<Integer> count,
                                        @RequestParam(name = "after") Optional<LocalDate> after,
                                        @RequestParam(name = "before") Optional<LocalDate> before) {

        log.info("get request: /api/tweet -> " + "kind: " + kind);

        return this.analyzedTweetService.getTweets(kind, count,
                after.map(date -> date.atStartOfDay()),
                before.map(date -> date.atStartOfDay()));
    }

    @RequestMapping(value = "/last25/{tweetSentiment}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Collection<AnalyzedTweet> simpleGetRecent(@PathVariable("tweetSentiment") SentimentKind tweetSentiment) {
        log.info("/api/bySentiment/{tweetSentiment} called with tweetSentiment: " + tweetSentiment);

        return this.analyzedTweetService.getTweets(
                Optional.of(tweetSentiment),
                Optional.of(25),
                Optional.empty(),
                Optional.empty());

    }

    @PostMapping("")
    public @ResponseBody
    Boolean saveTweet(@RequestBody RawTweet rawTweet) {
        log.info("pos request: /api/tweet -> " + rawTweet.getText());

        final Sentiment sentiment = this.sentimentAnalysisService.analyzeSingleSentiment(Locale.ENGLISH, rawTweet.getText());

        log.info(String.format("Tweet Text: %s -> %s%n", rawTweet.getText(), sentiment.getSentiment()));

        this.analyzedTweetService.saveAnalyzedTweet(new AnalyzedTweet(rawTweet, sentiment));
        return true;
    }

}
