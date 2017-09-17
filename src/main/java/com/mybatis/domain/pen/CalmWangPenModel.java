package com.mybatis.domain.pen;

import java.io.Serializable;

/**
 * 笔 model
 *
 * Created by yunkai on 2017/5/24.
 */
public class CalmWangPenModel implements Serializable{

    private Short ID;

    private String penName;//笔名称

    private Short userId;//用户ID

    public Short getID() {
        return ID;
    }

    public void setID(Short ID) {
        this.ID = ID;
    }

    public String getPenName() {
        return penName;
    }

    public void setPenName(String penName) {
        this.penName = penName;
    }

    public Short getUserId() {
        return userId;
    }

    public void setUserId(Short userId) {
        this.userId = userId;
    }
}
