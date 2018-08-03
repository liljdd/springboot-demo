package com.ant.service;

import com.ant.entity.User;
import com.ant.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lilj
 * @date 18/08/03
 */
@Service(value = "userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int addUser(User user) {

        return userMapper.insert(user);
    }

    /**
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     */
    public PageInfo<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        List<User> list = userMapper.selectUsers();
        PageInfo result = new PageInfo(list);
        return result;
    }

    public User findById(int id){
        return userMapper.selectByPrimaryKey(id);
    }
}
