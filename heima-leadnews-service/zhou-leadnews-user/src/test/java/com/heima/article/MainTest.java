package com.heima.article;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {
    private static final Logger logger = LoggerFactory.getLogger(MainTest.class);

    public static void main(String[] args) {
        System.out.println(logger.getClass());
    }

    @Test
    public void test1(){
        EnumTest[] values = EnumTest.values();
        for (EnumTest value : values) {
            System.out.println(value);
        }
    }
}

enum EnumTest{
    ENUMTEST("测试"),
    ENUMTEST1("测试1"),
    ENUMTEST2("测试2");

    EnumTest(String str){
        test = str;
    }

    String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
