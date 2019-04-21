package edu.rowan.rowansentimentanalysis.model;

/*
 * The result of sentiment analysis on a tweets
 * */

import com.amazonaws.services.comprehend.model.SentimentScore;

public class Sentiment {

    enum SentimentKind {
        POSITIVE,
        NEGATIVE,
        NEUTRAL,
        UNKNOWN
    }

    private SentimentKind sentiment;
    private SentimentScore score;

    public Sentiment(String sentiment, SentimentScore score) {

        this.sentiment = determineSentimentKind(sentiment);
        this.score = score;
    }

    private SentimentKind determineSentimentKind(final String sentiment) {
        switch (sentiment.toLowerCase()) {
            case "positive":
                return SentimentKind.POSITIVE;
            case "negative":
                return SentimentKind.NEGATIVE;
            case "neutral":
                return SentimentKind.NEUTRAL;
            default:
                return SentimentKind.UNKNOWN;
        }
    }

    @Override
    public String toString() {
        return "Sentiment{" +
                "sentiment='" + sentiment + '\'' +
                ", score=" + score +
                '}';
    }

    public SentimentKind getSentiment() {
        return this.sentiment;
    }

    public boolean isPositive() {
        return this.sentiment == SentimentKind.POSITIVE;
    }

    public boolean isNegative() {
        return this.sentiment == SentimentKind.NEGATIVE;
    }

    public boolean isNeutral() {
        return this.sentiment == SentimentKind.NEUTRAL;
    }

    public Float getPositiveScore() {
        return this.score.getPositive();
    }

    public Float getNegativeScore() {
        return this.score.getNegative();
    }

    public Float getNeutralScore() {
        return this.score.getNeutral();
    }
}
