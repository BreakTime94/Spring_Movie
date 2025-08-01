package com.climbjava.mreview.controller;

import com.climbjava.mreview.domain.dto.MovieDTO;
import com.climbjava.mreview.domain.dto.PageRequestDTO;
import com.climbjava.mreview.service.MovieService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@Controller
@RequestMapping("movie")
@Data
@Log4j2
public class MovieController {
  //private static final Logger log = LogManager.getLogManager(MovieController.class);
  private final MovieService service;

  @GetMapping("register")
  public void register(){

  }

  @PostMapping("register")
  public String register(MovieDTO dto, RedirectAttributes redirectAttributes){
    log.info(dto.getTitle());
    redirectAttributes.addFlashAttribute("msg", service.register(dto));
    return "redirect:/movie/register";
  }

  @GetMapping("list")
  public void list(@ModelAttribute("requestDto") PageRequestDTO dto, Model model){
    model.addAttribute("movies", service.getList(dto));
  }
  @GetMapping("read")
  public void read(@ModelAttribute("requestDto") PageRequestDTO dto, Model model, Long mno){
    model.addAttribute("dto",service.get(mno));
  }


}
