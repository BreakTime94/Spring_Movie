package com.climbjava.mreview;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@Log4j2
public class MreviewApplication {

  public static void main(String[] args) {
    log.info("Mreview 시작!");
    SpringApplication.run(MreviewApplication.class, args);
  }

}
