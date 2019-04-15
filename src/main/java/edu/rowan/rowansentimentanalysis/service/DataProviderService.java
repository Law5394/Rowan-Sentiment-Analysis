package edu.rowan.rowansentimentanalysis.service;

import edu.rowan.rowansentimentanalysis.model.TweetData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Provides data that has sentiment to be analyzed
 * should call 3rd party api to get data and provide to
 * this class' callers
 * */
// TODO implement this
@Service
public class DataProviderService {
  // Your api for twitter / whatever
  // value comes from src/main/resources/application.properties dps.api.key
  @Value("${dps.api.key}")
  private String apiKey;

  // TODO implement this
  private List<TweetData> getNewTweetsIfThereAreAny() {
    return null;
  }
}
