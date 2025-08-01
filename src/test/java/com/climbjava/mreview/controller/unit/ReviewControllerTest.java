package com.climbjava.mreview.controller.unit;

import com.climbjava.mreview.controller.ReviewController;
import com.climbjava.mreview.repository.ReviewRepository;
import com.climbjava.mreview.service.ReviewService;
import com.climbjava.mreview.service.ReviewServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ReviewController.class)
@ContextConfiguration(name = "application/yaml")
public class ReviewControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private ReviewServiceImpl service;

  @MockBean
  private ReviewRepository repository;

  @Test
  public void simpleGetList() throws Exception{
    Long mno = 100L;
    mockMvc.perform(MockMvcRequestBuilders.get(String.format("/review/@d/all", mno)));
  }
}
