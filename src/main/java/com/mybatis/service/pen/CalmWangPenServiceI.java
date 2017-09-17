package com.mybatis.service.pen;

import com.mybatis.domain.pen.CalmWangPenModel;

import java.util.List;

/**
 * pen service
 *
 * Created by yunkai on 2017/5/24.
 */
public interface CalmWangPenServiceI {

    /**
     * 获取所有笔信息
     *
     * @return
     */
    public List<CalmWangPenModel> findAll();

    /**
     * 获取用户所属笔信息
     *
     * @param userID  用户ID
     * @return
     */
    public List<CalmWangPenModel> findPenByUserID(Short userID);
}
