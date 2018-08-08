package com.ant.mapper;

import com.ant.entity.Student;
import com.ant.support.BaseMapper;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {
    @Override
    List<Student> selectAll();
}