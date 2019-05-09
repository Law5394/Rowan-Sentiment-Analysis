package edu.rowan.rowansentimentanalysis.service;

import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import edu.rowan.rowansentimentanalysis.repository.AnalyzedTweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyzedTweetService {

    @Autowired
    private AnalyzedTweetRepository repo;

    public void saveAnalyzedTweet(final AnalyzedTweet analyzedTweet) {
        this.repo.save(analyzedTweet);
    }

}
