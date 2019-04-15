package edu.rowan.rowansentimentanalysis.model;

import lombok.Data;
import org.springframework.core.io.UrlResource;

import java.util.Date;


/* A Twitter tweet
 * When calling twitters api you will probably get an array of tweets as json objects
 * modify this to match the json objects and deserialize to it
 * @Data generates getters/setters
 * */
@Data
public class TweetData {

  public Date timePosted;
  public String message;
  public UrlResource sourceUrl;
  public String sourceUser;

}
