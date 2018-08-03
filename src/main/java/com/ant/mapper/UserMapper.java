package com.ant.mapper;

import com.ant.entity.User;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}