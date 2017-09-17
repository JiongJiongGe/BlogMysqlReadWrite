package com.mybatis.dao.user;

import com.mybatis.config.ReadOnlyConnection;
import com.mybatis.domain.user.CalmWangUserModel;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * user dao
 *
 * Created by yunkai on 2017/5/24.
 */
@Mapper
@Component
public interface CalmWangUserDao {

    @Select("SELECT id, user_name, user_phone FROM `calmwang_t_user`")
    List<CalmWangUserModel> findAll();

//    @Select("<script>"+
//                "SELECT id, user_name, user_phone FROM miaoge_t_user " +
//                "<where> 1=1 " +
//                "<if test=\"name != null\"> AND user_name = #{name}</if>" +
//                "<if test=\"phone != null\"> AND user_phone = #{phone}</if>" +
//                "</where>"+
//            "</script>")

    /**
     * 传入对象，使用_parameter做if条件判断
     *
     * @param user
     * @return
     */
    @Select(" SELECT id, user_name, user_phone FROM `calmwang_t_user` WHERE 1=1 AND `user_name` = @{userName}"
            + "#if($!_parameter.userPhone) AND `user_phone` = @{userPhone} #end ")
    List<CalmWangUserModel>  getByNameAndPhone(CalmWangUserModel user);



    @Insert("INSERT INTO calmwang_t_user(id, user_name, user_phone) VALUES(NULL, @{param1}, @{param2})")
    void saveUser(@Param("name") String name, @Param("phone") String phone);

    @Select("SELECT LAST_INSERT_ID() AS ID")
    public Short last_insert_id();
}
