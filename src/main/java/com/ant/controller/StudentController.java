package com.ant.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ant.entity.Student;
import com.ant.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lilj
 * @date 18/08/08
 */
@Controller
@RequestMapping("student")
public class StudentController {
    /**
     * Logger for this class
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentService service;

    @RequestMapping("detail")
    @ResponseBody
    public JSONObject detail(Integer id) {
        System.out.println("============" + id);
        Student bean = service.queryById(id.longValue());
        String s = JSONObject.toJSONString(bean, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(s);
        return JSONObject.parseObject(s);
    }

    @RequestMapping("all")
    @ResponseBody
    public List<Student> all() {
        return service.queryAll();
    }

}
