package com.newer.service;

import com.newer.domain.TeaOrder;
import com.newer.mapper.TeaOrderMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TeaOrderService {
    private SqlSession sqlSession;
    private TeaOrderMapper teaOrderMapper;
    private void init(){
        sqlSession= SqlSessionUtil.getSqlSession();
        teaOrderMapper=sqlSession.getMapper(TeaOrderMapper.class);
    }
    public int addTeaOrder(TeaOrder teaOrder){
        init();
        int rows=teaOrderMapper.addTeaOrder(teaOrder);
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
        return rows;
    }
}
