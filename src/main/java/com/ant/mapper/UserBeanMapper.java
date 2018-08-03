package com.ant.mapper;

import com.ant.entity.UserBean;

public interface UserBeanMapper {
    int insert(UserBean record);

    int insertSelective(UserBean record);
}