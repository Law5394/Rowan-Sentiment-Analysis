package edu.rowan.rowansentimentanalysis.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/*
 * Should provide the resources that
 * makeup the sites frontend, html,css,jss, etc
 * */
@Log
@RestController
public class FrontendController {

  //
  // Handler for a certain method on a certain path
  // Should return home page of site
  // Todo add endpoints for other pages
  // or have one end point and return resource depending on pathname
  @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
  public String home() {
    return "home page";
  }
}
