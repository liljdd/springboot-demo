package com.ant.controller;

import com.ant.entity.Teacher;
import com.ant.service.TeacherService;
import com.github.pagehelper.PageInfo;
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
    @Autowired
    private TeacherService teacherService;

    @RequestMapping("detail")
    @ResponseBody
    public Teacher detail(Integer id) {
        return teacherService.findById(id);
    }

    @ResponseBody
    @RequestMapping("/all")
    public PageInfo<Teacher> findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return teacherService.findAll(pageNum, pageSize);
    }
}
