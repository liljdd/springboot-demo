package com.ant.mapper;

import com.ant.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    List<User> selectUsers();

    User selectByPrimaryKey(Integer id);
}