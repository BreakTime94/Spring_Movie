package com.climbjava.mreview.service;

import com.climbjava.mreview.domain.dto.MovieImageDTO;
import com.climbjava.mreview.domain.entity.Movie;
import com.climbjava.mreview.domain.entity.MovieImage;
import jakarta.persistence.Entity;

public interface MovieImageService {
  static MovieImage toEntity(MovieImageDTO dto) {
    return MovieImage.builder()
            .movie(Movie.builder().mno(dto.getMno()).build())
            .uuid(dto.getUuid())
            .imgName(dto.getOrigin())
            .build();
  }
}
