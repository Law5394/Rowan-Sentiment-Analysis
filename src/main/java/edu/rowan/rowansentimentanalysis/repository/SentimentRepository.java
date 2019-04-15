package edu.rowan.rowansentimentanalysis.repository;

import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import org.springframework.stereotype.Repository;

import java.util.List;

// Need to do this pretty much
// they have @Query annotation to right manual SQL
// should probably do some manual queries since he taught it in the class
// https://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html

// TODO implement this
@Repository
public class SentimentRepository {

  // Todo prob need a bunch of more specific
  // forms of this
  public List<AnalyzedTweet> getAnalyzedTweets() {
    return null;
  }

  // TODO implement this
  public void storeTweets(AnalyzedTweet... tweets) {

  }
}
