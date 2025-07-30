package com.climbjava.mreview.repository;

import com.climbjava.mreview.domain.entity.Member;
import com.climbjava.mreview.domain.entity.Movie;
import com.climbjava.mreview.domain.entity.Review;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class ReviewRepositoryTest {
  @Autowired
  ReviewRepository repository;


  @Test
  public void testExist() {
    Assertions.assertNotNull(repository);
    log.info(repository);
  }

  @Test
  @Transactional
  public void testInsert() {
    IntStream.rangeClosed(1, 200).forEach(i -> {
      Long mno = new Random().nextLong(100) + 1;
      Long mid = new Random().nextLong(100) + 1;

      Member member = Member.builder().mid(mid).build();

      Review movieReview = Review.builder()
              .member(member)
              .movie(Movie.builder().mno(mno).build())
              .grade(new Random().nextInt(5) + 1)
              .text("이 영화에 대한 느낌" + i)
              .build();
      repository.save(movieReview);
    });
  }
  @Test
  public void testFindByMovieMno() {
    repository.findByMovie_mno(99L).forEach( r -> {
      log.info(r);
      log.info(r.getMember());
      log.info(r.getMember().getEmail());
      //log.info(r.getMovie().getTitle());
      }
    );
  }


}
