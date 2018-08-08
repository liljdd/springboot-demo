package com.ant.mapper;

import com.ant.entity.User;

import java.util.List;

/**
 * 不需要@Repository注解
 */
//@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectAll();

    User selectByPrimaryKey(Integer id);
}