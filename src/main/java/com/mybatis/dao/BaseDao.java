package com.mybatis.dao;

import org.apache.ibatis.annotations.Select;

/**
 * basedao
 *
 * Created by yunkai on 2017/5/24.
 */
public interface BaseDao {

    /**
     * 获取上一次新增的记录ID
     *
     * @return
     */
    @Select("SELECT LAST_INSERT_ID() AS ID")
    public Short last_insert_id();
}
