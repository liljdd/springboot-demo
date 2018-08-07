package com.ant.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ant.entity.User;
import com.ant.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lilj
 * @date 18/08/03
 */
@Controller
@RequestMapping(value = "/user")
@EnableAutoConfiguration
public class UserController {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/add")
    public int addUser(User user) {
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping("/all")
    public PageInfo<User> findAllUser(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        PageInfo<User> page = userService.findAllUser(pageNum, pageSize);
        logger.info("==="+page);
        String s = JSONObject.toJSONString(page, SerializerFeature.WriteDateUseDateFormat);
        logger.info("========="+s);
        System.out.println(s);
        return page;
    }

    @ResponseBody
    @RequestMapping("/detail")
    public User findById(@RequestParam Integer id) {
        return userService.findById(id);
    }
}
