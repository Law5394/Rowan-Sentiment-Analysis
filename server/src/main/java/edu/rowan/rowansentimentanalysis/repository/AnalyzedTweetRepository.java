package edu.rowan.rowansentimentanalysis.repository;

import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import org.springframework.data.repository.CrudRepository;

public interface AnalyzedTweetRepository extends CrudRepository<AnalyzedTweet, Long> {
}
