package com.heima.article;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class MainTest {
    @Autowired
    private FileStorageService fileStorageService;

    @Test
    void test1(){
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\91192\\Desktop\\test.html");
            String filePath = fileStorageService.uploadHtmlFile("", "test.html", fileInputStream);
            System.out.println(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
