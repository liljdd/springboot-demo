package com.ant.mapper;

import com.ant.entity.Student;
import com.ant.support.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 通用mapper不能使用
 */
@Repository
public interface StudentMapper extends BaseMapper<Student> {
  /*  int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKeyWithBLOBs(Student record);

    int updateByPrimaryKey(Student record);

    @Select("select * from student")
    List<Student> selectAll();*/
}