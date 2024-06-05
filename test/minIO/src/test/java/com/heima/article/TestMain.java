package com.heima.article;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.FileInputStream;

@SpringBootTest
class TestMain {
    @Test
    void test1(){
        FileInputStream fileInputStream = null;
        try {

            fileInputStream =  new FileInputStream("C:\\Users\\91192\\Desktop\\不会.txt");

            //1.创建minio链接客户端
            MinioClient minioClient = MinioClient.builder().credentials("minio", "minio123").endpoint("http://192.168.200.130:9000").build();
            //2.上传
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .object("不会.txt")//文件名
                    .contentType("text")//文件类型
                    .bucket("leadnews")//桶名词  与minio创建的名词一致
                    .stream(fileInputStream, fileInputStream.available(), -1) //文件流
                    .build();
            minioClient.putObject(putObjectArgs);

            System.out.println("http://192.168.200.130:9000/leadnews/不会.txt");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
