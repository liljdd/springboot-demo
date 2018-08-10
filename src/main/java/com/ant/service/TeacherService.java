package com.ant.service;

import com.ant.entity.Teacher;
import com.ant.mapper.TeacherMapper;
import com.ant.support.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lilj
 * @date 18/08/07
 */
@Service
public class TeacherService extends BaseService<Teacher> {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TeacherMapper teacherMapper;

    public Teacher findById(Integer id){
        logger.info("=========id="+id);
        Teacher teacher = teacherMapper.selectByPrimaryKey(id);
        logger.info("teacher=="+teacher);
        Teacher t = new Teacher();
        int i = teacherMapper.selectCount(t);
        logger.info("===i="+i);
        t.setName("a");
        int j = teacherMapper.selectCount(t);
        logger.info("===j="+j);
        return teacher;
    }

}
