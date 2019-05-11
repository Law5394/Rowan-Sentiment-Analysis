package edu.rowan.rowansentimentanalysis.controller;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

import edu.rowan.rowansentimentanalysis.SentimentKind;
import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import edu.rowan.rowansentimentanalysis.model.SentimentAverage;
import edu.rowan.rowansentimentanalysis.service.AnalyzedTweetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/time-stats")
public class TimePeriodStatController {

    private static final Logger log = LoggerFactory.getLogger(TimePeriodStatController.class);
    private AnalyzedTweetService analyzedTweetService;

    @Autowired
    public TimePeriodStatController(AnalyzedTweetService analyzedTweetService) {
        log.debug("TimePeriodStatController Controller instantiated");
        this.analyzedTweetService = analyzedTweetService;
    }

    @GetMapping("/monthly-average")
    public SentimentAverage getMonthlyAverageSentiment() {
        log.info("Request on /time-stats/monthly-average");

        final LocalDateTime start = LocalDate.now().atStartOfDay().withDayOfMonth(1);
        final LocalDateTime end = LocalDate.now().atStartOfDay().with(lastDayOfMonth());

        return calcAverage(start, end);
    }

    @GetMapping("/daily-average")
    public SentimentAverage getDailyAverageSentiment() {
        log.info("Request on /time-stats/daily-average");

        return calcAverage(LocalDate.now().atStartOfDay(),
                LocalDate.now().atStartOfDay().plusDays(1));
    }

    private SentimentAverage calcAverage(final LocalDateTime start, final LocalDateTime end) {
        Collection<AnalyzedTweet> tweets = this.analyzedTweetService.getTweets(
                Optional.empty(),
                Optional.of(Integer.MAX_VALUE),
                Optional.of(start),
                Optional.of(end));

        log.info("Number of tweets posted today:" + tweets.size());

        for (AnalyzedTweet tweet : tweets) {
            System.out.println("Tweet:" + tweet.getText());
        }
        double positiveAverage = tweets.stream().mapToDouble(tweet -> tweet.getPosScore()).average()
                .orElseGet(() -> 0.0);
        double negativeAverage = tweets.stream().mapToDouble(tweet -> tweet.getNegScore()).average()
                .orElseGet(() -> 0.0);
        double neutralAverage = tweets.stream().mapToDouble(tweet -> tweet.getNeutralScore()).average()
                .orElseGet(() -> 0.0);

        final SentimentAverage sentimentAverage = new SentimentAverage();

        sentimentAverage.setPositiveScore(positiveAverage);
        sentimentAverage.setNegativeScore(negativeAverage);
        sentimentAverage.setNeutralScore(neutralAverage);

        if (Double.compare(positiveAverage, negativeAverage) > 0
                && Double.compare(positiveAverage, neutralAverage) > 0) {
            sentimentAverage.setKind(SentimentKind.POSITIVE);
        } else if (Double.compare(negativeAverage, positiveAverage) > 0
                && Double.compare(negativeAverage, neutralAverage) > 0) {
            sentimentAverage.setKind(SentimentKind.NEGATIVE);
        } else {
            sentimentAverage.setKind(SentimentKind.NEUTRAL);
        }

        return sentimentAverage;
    }
}
