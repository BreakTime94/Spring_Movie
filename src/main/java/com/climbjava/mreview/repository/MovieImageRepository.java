package com.climbjava.mreview.repository;

import com.climbjava.mreview.domain.entity.MovieImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieImageRepository extends JpaRepository<MovieImage,Long> {
}
