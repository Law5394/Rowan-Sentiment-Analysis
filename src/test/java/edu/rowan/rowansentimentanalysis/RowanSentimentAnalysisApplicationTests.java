package edu.rowan.rowansentimentanalysis;

import edu.rowan.rowansentimentanalysis.repository.SentimentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RowanSentimentAnalysisApplicationTests {

	@Test
	public void contextLoads() {
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
