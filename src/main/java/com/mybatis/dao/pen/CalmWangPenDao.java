package com.mybatis.dao.pen;

import com.mybatis.domain.pen.CalmWangPenModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * pen dao
 *
 * Created by yunkai on 2017/5/24.
 */
@Mapper
@Component
public interface CalmWangPenDao {

    @Select("SELECT id, pen_name, user_id FROM calmwang_t_pen")
    List<CalmWangPenModel> findAll();

    @Select("SELECT id, pen_name FROM calmwang_t_pen WHERE user_id = #{userID}")
    List<CalmWangPenModel> findPensByUserID(Short userID);
}
