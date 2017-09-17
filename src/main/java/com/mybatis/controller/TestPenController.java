package com.mybatis.controller;

import com.mybatis.domain.pen.CalmWangPenModel;
import com.mybatis.service.pen.CalmWangPenServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 测试  笔
 *
 * Created by yunkai on 2017/5/24.
 */
@RestController
@RequestMapping("test")
public class TestPenController {

    @Autowired
    private CalmWangPenServiceI calmWangPenService;

    /**
     * 获取笔列表信息
     *
     * @return
     */
    @GetMapping(value = "findPenList")
    public List<CalmWangPenModel> findPenList() {
        List<CalmWangPenModel> pens = calmWangPenService.findAll();
        return pens;
    }

    @GetMapping(value = "findPenByUserID")
    public List<CalmWangPenModel> findPenByUserID(Short userID) {
        List<CalmWangPenModel> pens = calmWangPenService.findPenByUserID(userID);
        return pens;
    }
}
