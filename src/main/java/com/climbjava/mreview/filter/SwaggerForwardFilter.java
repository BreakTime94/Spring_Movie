package com.climbjava.mreview.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class SwaggerForwardFilter implements Filter {
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) servletRequest;
    HttpServletResponse res = (HttpServletResponse) servletResponse;

    String uri = req.getRequestURI();

    if (uri.equals("/swag")) {
      // index.html 읽기
      InputStream inputStream = getClass().getResourceAsStream("/META-INF/resources/webjars/swagger-ui/5.21.0/index.html");

      if (inputStream == null) {
        res.sendError(HttpServletResponse.SC_NOT_FOUND);
        return;
      }

      String html = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

      // 상대 경로를 절대 경로로 수정
      html = html.replace("./", "/swagger-ui/5.21.0/")
              .replace("index.css", "/swagger-ui/5.21.0/index.css");

      // 헤더 설정
      res.setContentType("text/html;charset=UTF-8");
      res.getWriter().write(html);
      return;
    }

    // 나머지는 그대로 처리
    filterChain.doFilter(servletRequest, servletResponse);
  }
}
