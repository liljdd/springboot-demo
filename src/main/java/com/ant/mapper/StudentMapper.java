package com.ant.mapper;

import com.ant.entity.Student;
import com.ant.support.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface StudentMapper extends BaseMapper<Student> {

    @Select("select * from student")
    List<Student> selectAll();
}