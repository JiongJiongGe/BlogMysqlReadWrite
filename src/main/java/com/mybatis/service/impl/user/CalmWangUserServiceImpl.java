package com.mybatis.service.impl.user;

import com.mybatis.config.ReadOnlyConnection;
import com.mybatis.dao.user.CalmWangUserDao;
import com.mybatis.domain.user.CalmWangUserModel;
import com.mybatis.service.user.CalmWangUserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yunkai on 2017/5/24.
 */
@Service
@Transactional
public class CalmWangUserServiceImpl implements CalmWangUserServiceI {

    @Autowired
    private CalmWangUserDao miaoGeUserDao;

    @Override
    @ReadOnlyConnection
    public List<CalmWangUserModel> findUserList() {
        List<CalmWangUserModel> users = miaoGeUserDao.findAll();
        return users;
    }

    @Override
    public List<CalmWangUserModel> getByName(String name) {
        CalmWangUserModel user = new CalmWangUserModel();
        user.setUserName(name);
        user.setUserPhone("13588313834");
        List<CalmWangUserModel> users = miaoGeUserDao.getByNameAndPhone(user);
        return users;
    }

    @Override
    public Short saveUser(String userName, String userPhone) {
        CalmWangUserModel user = new CalmWangUserModel();
        user.setUserPhone(userPhone);
        user.setUserName(userName);
        miaoGeUserDao.saveUser(userName, userPhone);
        Short userID = miaoGeUserDao.last_insert_id();
        return userID;
    }
}
