package com.ant.springbootdemo;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ant.entity.Student;
import com.ant.entity.User;
import com.ant.service.StudentService;
import com.ant.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;
    @Test
    public void userTest01() {
        User user = userService.findById(1);
        String s = JSONObject.toJSONString(user, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(s);
    }

    @Test
    public void studentTest01() {
        List<Student> list = studentService.findAll();
        Object o = JSONObject.toJSON(list);
        System.out.println(o.toString());
    }

}
