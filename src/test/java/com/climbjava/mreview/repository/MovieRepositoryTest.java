package com.climbjava.mreview.repository;

import com.climbjava.mreview.domain.entity.Movie;
import com.climbjava.mreview.domain.entity.MovieImage;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.LongStream;

@SpringBootTest
@Log4j2
public class MovieRepositoryTest {
  @Autowired
  private MovieRepository repository;

  @Autowired
  private MovieImageRepository movieImageRepository;

  @Test
  @DisplayName("존재여부 확인")
  public void testExist(){
    Assertions.assertNotNull(repository);
    log.info(repository);
  }

  @Test
  @Transactional
  public void testInsert(){
    LongStream.rangeClosed(1, 100).forEach(i->{
      Movie movie = Movie.builder().title("Movie" + i).build();
      repository.save(movie);
      int count = (int)(Math.random() * 5) + 1; // 1, 2, 3, 4

      for(int j = 0; j < count; j++){
        MovieImage movieImage = MovieImage.builder()
                .uuid(UUID.randomUUID().toString())
                .movie(movie)
                .imgName("test" + j + ".jpg")
                .build();
        movieImageRepository.save(movieImage);
      }
    });
  }

  @Test
  public void testGetListPage() {
    Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
    repository.getListPage(pageable).forEach(m -> log.info(Arrays.toString(m)));
  }

  @Test
  public void testGetMovieWithAll(){
    repository.getMovieWithAll(100L).forEach(m -> log.info(Arrays.toString(m)));
  }

}
