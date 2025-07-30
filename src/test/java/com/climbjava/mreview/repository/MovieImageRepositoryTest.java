package com.climbjava.mreview.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MovieImageRepositoryTest {
  @Autowired
  private MovieImageRepository repository;

  @Test
  public void testExist() {
    Assertions.assertNotNull(repository);
    log.info(repository);
  }
}
