package com.heima.article;

import com.heima.article.pojo.Student;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class FreeMarkerTest {
    @Autowired
    Configuration configuration;

    @Test
    void tes1() throws IOException, TemplateException {
        Template template = configuration.getTemplate("02-list.ftl");

        Student stu1 = new Student();
        stu1.setName("小强");
        stu1.setAge(18);
        stu1.setMoney(1000.86f);
        stu1.setBirthday(new Date());

        //小红对象模型数据
        Student stu2 = new Student();
        stu2.setName("小红");
        stu2.setMoney(200.1f);
        stu2.setAge(19);

        //将两个对象模型数据存放到List集合中
        List<Student> stus = new ArrayList<>();
        stus.add(stu1);
        stus.add(stu2);

        //向model中存放List集合数据
        //创建Map数据
        HashMap<String,Student> stuMap = new HashMap<>();
        stuMap.put("stu1",stu1);
        stuMap.put("stu2",stu2);

        HashMap<String, Object> result = new HashMap<>();
        result.put("stus", stus);
        result.put("stuMap", stuMap);
        String dir = System.getProperty("user.dir");
        String path = dir.concat("\\src\\main\\resources\\templates\\");
        String fileName = path + "list.html";
        template.process(result, new FileWriter(fileName));
    }
}
