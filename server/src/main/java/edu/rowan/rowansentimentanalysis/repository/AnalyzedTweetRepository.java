package edu.rowan.rowansentimentanalysis.repository;

import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;


public interface AnalyzedTweetRepository extends CrudRepository<AnalyzedTweet, Long> {

    @Query(value = "SELECT * FROM analyzed_tweet " +
            "WHERE kind LIKE :kindParam " +
            "AND date BETWEEN :lowerDateParam AND :upperDateParam",
            nativeQuery = true)
    Page<AnalyzedTweet> getAllTweets(@Param("kindParam") String kind,
                                     @Param("lowerDateParam") LocalDateTime lowerDate,
                                     @Param("upperDateParam") LocalDateTime upperDate,
                                     Pageable p);
}
