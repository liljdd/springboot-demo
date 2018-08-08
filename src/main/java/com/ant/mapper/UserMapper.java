package com.ant.mapper;

import com.ant.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 不需要@Repository注解，没有注解 service层@Autowired会报错，但不影响
 */
@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectAll();

    User selectByPrimaryKey(Integer id);
}