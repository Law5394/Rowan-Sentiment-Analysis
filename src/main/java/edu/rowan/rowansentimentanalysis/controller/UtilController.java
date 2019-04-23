package edu.rowan.rowansentimentanalysis.controller;

import edu.rowan.rowansentimentanalysis.service.ScheduledProcessingService;
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
public class UtilController {

  private static final Logger log = LoggerFactory.getLogger(UtilController.class);
  private ScheduledProcessingService processingService;

  @Autowired // Automatically gives UtilController a reference to dependencies
  public UtilController(ScheduledProcessingService processingService) {
    this.processingService = processingService;
  }

  // test if the api is up
  @RequestMapping(value = "/util/test", method = RequestMethod.GET, produces = "application/json")
  public String testApi() {
    log.info("/util/test/ called");
    return "up";
  }

  // check when the api was last updated
  // TODO implement this
  @RequestMapping(value = "/util/lastUpdate", method = RequestMethod.GET, produces = "application/json")
  public Date lastUpdated() {
    log.info("/util/lastUpdate/ called");
    // this.processingService.getTimeLastUpdated();
    return null;
  }
}
