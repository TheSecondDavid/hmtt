package com.heima.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayUser {
    public static void main(String[] args) {
        SpringApplication.run(GatewayUser.class, args);
    }
}
