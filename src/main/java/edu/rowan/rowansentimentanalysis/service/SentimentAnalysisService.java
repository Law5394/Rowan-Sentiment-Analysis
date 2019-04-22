package edu.rowan.rowansentimentanalysis.service;


import edu.rowan.rowansentimentanalysis.model.Sentiment;

import java.util.List;
import java.util.Locale;

public interface SentimentAnalysisService {
    public Sentiment analyzeSingleSentiment(final Locale langCode,
                                            final String text);

    public List<Sentiment> analyzeSentiments(final Locale langCode,
                                             final String... text);
}
