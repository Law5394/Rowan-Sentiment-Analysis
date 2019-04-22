package edu.rowan.rowansentimentanalysis.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.comprehend.AmazonComprehend;
import com.amazonaws.services.comprehend.AmazonComprehendClientBuilder;
import com.amazonaws.services.comprehend.model.BatchDetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentRequest;
import com.amazonaws.services.comprehend.model.DetectSentimentResult;
import com.amazonaws.services.comprehend.model.LanguageCode;
import edu.rowan.rowansentimentanalysis.model.Sentiment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/*
 * A service that provides sentiment analysis
 * - Should accept data and call relevant 3rd party api's
 * to conduct sentiment analysis on the data
 * */

@Service(value = "aws")
public class AWSComprehendService implements SentimentAnalysisService {

    protected AmazonComprehend comprehendClient;

    @Autowired
    public AWSComprehendService(@Value("${aws.key.id}") String awsAccessID,
                                @Value("${aws.key.secret}") String awsSecret) {

        BasicAWSCredentials credentials = new BasicAWSCredentials(awsAccessID, awsSecret);

        this.comprehendClient = AmazonComprehendClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .build();
    }

    private LanguageCode toAWSLangCode(final Locale langCode) {
        return LanguageCode.fromValue(langCode.toLanguageTag());
    }

    public List<Sentiment> analyzeSentiments(final Locale langCode,
                                             final String... text) {

        return (text.length == 1) ?
                Arrays.asList(analyzeSingleSentiment(langCode, text[0])) :
                batchAnalyzeSentiment(text, toAWSLangCode(langCode));
    }

    public Sentiment analyzeSingleSentiment(final Locale langCode,
                                            final String text) {

        DetectSentimentResult result = this.comprehendClient.detectSentiment(new DetectSentimentRequest()
                .withLanguageCode(toAWSLangCode(langCode))
                .withText(text));

        return new Sentiment(result.getSentiment(), result.getSentimentScore());
    }

    private List<Sentiment> batchAnalyzeSentiment(final String[] textList,
                                                  final LanguageCode langCode) {

        return this.comprehendClient.batchDetectSentiment(new BatchDetectSentimentRequest()
                .withLanguageCode(langCode)
                .withTextList(textList))
                .getResultList()
                .stream()
                .map(res -> new Sentiment(res.getSentiment(), res.getSentimentScore()))
                .collect(Collectors.toList());
    }
}
