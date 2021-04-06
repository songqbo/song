package com.manong.service.impl;

import com.manong.dao.IGoodsDao;
import com.manong.entity.Goods;
import com.manong.service.IGoodsService;
import com.manong.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 16:53
 */
@Service
public class IGoodsServiceImpl implements IGoodsService {

    public List<Goods> queAllGoods() {
        SqlSession sqlSession = MybatisUtil.mybatisTool(false);
        IGoodsDao goodsDao = sqlSession.getMapper(IGoodsDao.class);
        List<Goods> goods = goodsDao.queAllGoods();
        return goods;
    }

    @Override
    public Goods queById(int id) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(false);
        IGoodsDao goodsDao = sqlSession.getMapper(IGoodsDao.class);
        Goods good = goodsDao.queById(id);
        return good;
    }

    public void updGoods(Goods goods){
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IGoodsDao goodsDao = sqlSession.getMapper(IGoodsDao.class);
        goodsDao.updGoods(goods);
    }

    public void addGood(Goods goods){
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IGoodsDao goodsDao = sqlSession.getMapper(IGoodsDao.class);
        goodsDao.addGood(goods);
    }

    @Override
    public List<Goods> queGoodNames() {
        SqlSession sqlSession = MybatisUtil.mybatisTool(false);
        IGoodsDao goodsDao = sqlSession.getMapper(IGoodsDao.class);
        List<Goods> goods = goodsDao.queGoodNames();
        return goods;
    }


}
