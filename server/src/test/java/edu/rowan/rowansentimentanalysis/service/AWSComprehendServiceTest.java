package edu.rowan.rowansentimentanalysis.service;

import com.amazonaws.services.comprehend.model.LanguageCode;
import edu.rowan.rowansentimentanalysis.model.Sentiment;
import edu.rowan.rowansentimentanalysis.repository.SentimentRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/*
 * Integration test for AnalysisService ->  AWS Comprehend
 * consumes 6 units of text worth of api req per run
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {AWSComprehendService.class})
public class AWSComprehendServiceTest {

    private static final String positiveString = "I am so happy";
    private static final String negativeString = "I am so sad";

    @Autowired
    private AWSComprehendService service;

    private Collection<Sentiment> positiveSingleResultList;
    private Collection<Sentiment> negativeSingleResultList;
    private Collection<Sentiment> multipleResultList;


    @Before
    public void init() {

        this.positiveSingleResultList = this.service.analyzeSentiments(
                Locale.ENGLISH,
                positiveString
        );

        this.negativeSingleResultList = this.service.analyzeSentiments(
                Locale.ENGLISH,
                negativeString
        );

        this.multipleResultList = this.service.analyzeSentiments(
                Locale.ENGLISH,
                positiveString, negativeString, positiveString, negativeString
        );

    }

    @Test
    public void analyzeSingleSentimentPositiveTest() {
        Optional<Sentiment> first = this.positiveSingleResultList.stream().findFirst();

        assertThat(first.isPresent()).isTrue();
        final Sentiment sentiment = first.get();

        assertThat(sentiment.isPositive()).isTrue();
        assertThat(sentiment.getPositiveScore())
                .isGreaterThan(sentiment.getNegativeScore());
    }

    @Test
    public void analyzeSingleSentimentNegativeTest() {

        Optional<Sentiment> first = this.negativeSingleResultList.stream().findFirst();
        assertThat(first.isPresent()).isTrue();
        final Sentiment sentiment = first.get();
        System.out.println("sent: " + sentiment);
        assertThat(sentiment.isNegative()).isTrue();
        assertThat(sentiment.getNegativeScore())
                .isGreaterThan(sentiment.getPositiveScore());
    }

    @Test
    public void analyzeMultipleSentimentTest() {
        List<Sentiment> sentiments = this.multipleResultList.stream().collect(Collectors.toList());

        assertThat(sentiments.get(0).isPositive()).isTrue();
        assertThat(sentiments.get(1).isNegative()).isTrue();
        assertThat(sentiments.get(2).isPositive()).isTrue();
    }

    @Test
    public void sizeTest() {
        assertThat(this.positiveSingleResultList.size()).isEqualTo(1);
        assertThat(this.negativeSingleResultList.size()).isEqualTo(1);
        assertThat(this.multipleResultList.size()).isGreaterThan(1);
    }

    // So it wont spin up database connections that
    // take long and are not relevant to testing
    @Configuration
    @Import(SentimentRepository.class)
    static class TestConfig {
        @Bean
        SentimentRepository sentimentRepository() {
            return mock(SentimentRepository.class);
        }
    }

}
