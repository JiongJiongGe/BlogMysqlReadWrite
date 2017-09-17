package com.mybatis.controller;

import com.mybatis.domain.user.CalmWangUserModel;
import com.mybatis.service.user.CalmWangUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试 用户
 *
 * Created by yunkai on 2017/5/24.
 */
@RestController
@RequestMapping("test")
public class TestUserController {

    @Autowired
    private CalmWangUserServiceI calmWangUserService;

    /**
     * 测试请求链接是否成功
     *
     * @return
     */
    @GetMapping(value = "getTest")
    public String getTest() {
        return "wjd  is  good";
    }

    /**
     * 测试获取所有用户数据
     *
     * @return
     */
    @GetMapping(value = "testService")
    public List<CalmWangUserModel> testService() {
        List<CalmWangUserModel> users = calmWangUserService.findUserList();
        return users;
    }

    /**
     * 测试获取所有用户数据  POST方法
     * @param name
     * @param phone
     * @return
     */
    @GetMapping(value = "userListJson")
    public List<CalmWangUserModel> userListJson(String name, String phone) {
        List<CalmWangUserModel> users = calmWangUserService.findUserList();
        return users;
    }

    /**
     * 根据用户姓名获取用户信息
     *
     * @param name
     * @return
     */
    @GetMapping(value = "getByName")
    public List<CalmWangUserModel>  getByName(String name) {
        List<CalmWangUserModel> users = calmWangUserService.getByName(name);
        return users;
    }

    /**
     * 保存用户信息
     *
     * @param userName  用户姓名
     * @param userPhone  用户联系方式
     * @return
     */
    @GetMapping(value = "saveUserJson")
    public Short saveUserJson(String userName, String userPhone) {
        Short userID = calmWangUserService.saveUser(userName, userPhone);
        return userID;
    }
}
