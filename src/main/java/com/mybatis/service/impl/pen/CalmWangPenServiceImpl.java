package com.mybatis.service.impl.pen;

import com.mybatis.dao.pen.CalmWangPenDao;
import com.mybatis.domain.pen.CalmWangPenModel;
import com.mybatis.service.pen.CalmWangPenServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yunkai on 2017/5/24.
 */
@Service("miaoGePenService")
@Transactional
public class CalmWangPenServiceImpl implements CalmWangPenServiceI {

    @Autowired
    private CalmWangPenDao miaoGePenDao;

    @Override
    public List<CalmWangPenModel> findAll() {
        List<CalmWangPenModel> pens = miaoGePenDao.findAll();
        return pens;
    }

    @Override
    public List<CalmWangPenModel> findPenByUserID(Short userID) {
        List<CalmWangPenModel> pens = miaoGePenDao.findPensByUserID(userID);
        return pens;
    }
}
