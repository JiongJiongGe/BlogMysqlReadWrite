package com.mybatis.domain.user;

import java.io.Serializable;

/**
 * 用户model
 *
 * Created by yunkai on 2017/5/24.
 */
public class CalmWangUserModel implements Serializable{

    private Short ID;

    private String userName; //用户名称

    private String userPhone;//用户联系方式

    public Short getID() {
        return ID;
    }

    public void setID(Short ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
