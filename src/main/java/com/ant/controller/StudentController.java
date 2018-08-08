package com.ant.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ant.entity.Student;
import com.ant.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private static final Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService service;

    @RequestMapping("detail")
    public JSONObject detail(Integer id){
        System.out.println("============"+id);
        Student bean = service.findById(id);
        String s = JSONObject.toJSONString(bean, SerializerFeature.WriteDateUseDateFormat);
        System.out.println(s);
        return JSONObject.parseObject(s);
    }
}
