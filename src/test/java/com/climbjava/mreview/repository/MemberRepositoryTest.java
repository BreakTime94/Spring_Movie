package com.climbjava.mreview.repository;

import com.climbjava.mreview.domain.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.LongStream;

@SpringBootTest
@Log4j2
public class MemberRepositoryTest {
  @Autowired
  private MemberRepository repository;
  @Autowired
  private ReviewRepository reviewRepository;

  @Test
  public void testExist() {
    Assertions.assertNotNull(repository);
    log.info(repository);
  }

  @Test
  @Transactional
  public void testInsert() {
    LongStream.rangeClosed(1, 100).forEach(i->{
      Member member = Member.builder()
              .email("r" + i + "@zerock.org")
              .pw("1111")
              .nickname("reviewer" + i)
              .build();
      repository.save(member);
    });
  }

  @Test
  @Transactional
  @Commit
  public void testDeleteByMemberMid(){
    Long mid = 20L;
    reviewRepository.deleteByMember_mid(mid);
    repository.deleteById(mid);
  }



}
