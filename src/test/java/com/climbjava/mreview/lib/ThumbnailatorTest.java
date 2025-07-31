package com.climbjava.mreview.lib;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SpringBootTest
@Log4j2
public class ThumbnailatorTest {
  @Test
  public void testConvert() throws IOException {
    File f = new File("C:\\Users\\tj\\Desktop\\test", "sampledog.png");
    log.info(f.exists());
    BufferedImage originalImage = ImageIO.read(f);
    log.info(originalImage);
    BufferedImage thumbnail = Thumbnails.of(originalImage).size(200, 200).asBufferedImage();

    ImageIO.write(thumbnail, "png", new File("C:\\Users\\tj\\Desktop\\test\\", "sampledog.webp"));
  }
  @Test
  @DisplayName("원본 해상도 유지 및 해상도만 변경")
  public void testConvert2() throws IOException {
    File f = new File("C:\\Users\\tj\\Desktop\\test", "samplecat.png");

    BufferedImage originalImage = ImageIO.read(f);

    ImageIO.write(originalImage, "png", new File("C:\\Users\\tj\\Desktop\\test\\", "samplecat.webp"));
  }
}
