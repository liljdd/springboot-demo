package com.ant.service;

import com.ant.entity.Student;
import com.ant.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilj
 * @date 18/08/08
 */
@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public Student findById(Integer id){
        return studentMapper.selectByPrimaryKey(id);
    }

    public List<Student> findAll(){
        return studentMapper.selectAll();
    }
}
