package edu.rowan.rowansentimentanalysis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/*
 * To test api easily
 * @Log: Provides access to log object
 * so can call log.info() to print log text
 * */
@RestController
@RequestMapping("/util")
public class UtilController {

  private static final Logger log = LoggerFactory.getLogger(UtilController.class);

  // test if the api is up
  @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "text/plain")
  public String testApi() {
    log.info("/util/test/ called");
    return "up";
  }

  // check when the api was last updated
  // TODO implement this
  @RequestMapping(value = "/lastUpdate", method = RequestMethod.GET, produces = "application/json")
  public Date lastUpdated() {
    log.info("/util/lastUpdate/ called");
    // this.processingService.getTimeLastUpdated();
    return null;
  }
}
