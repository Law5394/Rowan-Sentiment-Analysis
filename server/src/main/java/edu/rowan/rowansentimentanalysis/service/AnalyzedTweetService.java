package edu.rowan.rowansentimentanalysis.service;

import edu.rowan.rowansentimentanalysis.SentimentKind;
import edu.rowan.rowansentimentanalysis.model.AnalyzedTweet;
import edu.rowan.rowansentimentanalysis.repository.AnalyzedTweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnalyzedTweetService {

    private static Date timeLastAdded;

    @Value("${default.result.count}")
    private Integer defaultResultCount;
    @Autowired
    private AnalyzedTweetRepository repo;

    public void saveAnalyzedTweet(final AnalyzedTweet analyzedTweet) {
        timeLastAdded = new Date();
        this.repo.save(analyzedTweet);
    }

    public Collection<AnalyzedTweet> getTweets(final Optional<SentimentKind> kind,
                                               final Optional<Integer> limit,
                                               final Optional<LocalDateTime> lower,
                                               final Optional<LocalDateTime> upper) {

        Page<AnalyzedTweet> date = this.repo.getAllTweets(
                kind.map(SentimentKind::toString).orElseGet(() -> "%"),
                lower.orElseGet(() -> LocalDate.parse("2000-01-01").atStartOfDay()),
                upper.orElseGet(() -> LocalDate.parse("3000-01-01").atStartOfDay()),
                PageRequest.of(0, limit.orElseGet(() -> defaultResultCount), Sort.Direction.DESC, "date")
        );

        return date.get().collect(Collectors.toCollection(ArrayList::new));
    }

    public Optional<Date> getTimeLastAdded() {
        return Optional.ofNullable(timeLastAdded);
    }

}
