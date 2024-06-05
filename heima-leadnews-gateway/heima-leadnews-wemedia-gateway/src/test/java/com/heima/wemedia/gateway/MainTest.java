package com.heima.wemedia.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MainTest {
    @Test
    void test1(){
        System.out.println(TestInterface.helloWorld());
    }
    @Test
    void test2(){

    }
}

interface TestInterface{
    static String helloWorld(){
        return "hello world！";
    }
    String helloWorld(String str);
}

