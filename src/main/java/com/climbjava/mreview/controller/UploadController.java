package com.climbjava.mreview.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

@Controller
@Log4j2
public class UploadController {
  @Value("${spring.servlet.multipart.location}")
  private String uploadPath;

  @PostMapping("uploadAjax")
  public @ResponseBody ResponseEntity<?> uploadAjax(MultipartFile[] files){

    return ResponseEntity.ok(Arrays.stream(files).map(f -> {
      //이미지만 업로드 가능
      boolean image = f.getContentType().startsWith("image");
      if(!image){
        log.warn(image + "is not supported");
        return ResponseEntity.badRequest().build();
      }
      //기본 정보
      String originalName = f.getOriginalFilename();

      //ext 확장자 추출
      int idx = originalName.lastIndexOf(".");
      String ext = "";
      if(idx >= 0) {
        ext = originalName.substring(idx);
      }

      String fileName = UUID.randomUUID() + ext;
      String path = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
      String realPath = uploadPath + "/files/" + path + "/";

      log.info("realPath: {} fileName: {}", realPath, fileName);
      try {
        File file = new File(realPath + fileName);
        if(!file.exists()) {
          file.mkdirs();
        }
        f.transferTo(file);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }

      return Map.of("fileNmae", fileName, "size", f.getSize(), "uuid", UUID.randomUUID().toString(), "path", realPath);
    }).toList());
  }
  @GetMapping("uploadEx")
  public void uploadEx(){

  }
}
