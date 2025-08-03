package com.climbjava.mreview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("swag")
public class SwaggerController {
  @GetMapping("review")
  public String openReviewSwag() {
    return "forward:/swagger-ui/index.html#/review-controller";
  }
}
