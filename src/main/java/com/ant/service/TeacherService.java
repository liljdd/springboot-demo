package com.ant.service;

import com.ant.entity.Teacher;
import com.ant.mapper.TeacherMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilj
 * @date 18/08/07
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    public PageInfo<Teacher> findAll(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<Teacher> list = teacherMapper.selectAll();
        PageInfo result = new PageInfo(list);
        return result;
    }

    public Teacher findById(Integer id){
        return teacherMapper.selectByPrimaryKey(id);
    }
}
