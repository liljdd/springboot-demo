package com.ant.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ant.entity.Teacher;
import com.ant.service.TeacherService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lilj
 * @date 18/08/07
 */
@Controller
@RequestMapping("teacher")
public class TeacherController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("detail")
    @ResponseBody
    public Teacher detail(Integer id) {
        Teacher bean = teacherService.findById(id);
        String s = JSONObject.toJSONString(bean, SerializerFeature.WriteDateUseDateFormat);
        logger.info("=============s="+s);
        logger.info("=============bean="+bean);
        return bean;
    }

    @ResponseBody
    @RequestMapping("/all")
    public PageInfo<Teacher> findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        logger.info("=======pageNum="+pageNum+"=====pageSize=="+pageSize);
        return teacherService.queryListByPage(pageNum,pageSize);
    }
}
