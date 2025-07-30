package com.climbjava.mreview.repository;

import com.climbjava.mreview.domain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
