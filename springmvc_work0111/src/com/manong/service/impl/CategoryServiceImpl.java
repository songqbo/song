package com.manong.service.impl;

import com.manong.dao.ICategoryDao;
import com.manong.entity.WCategory;
import com.manong.service.CategoryService;
import com.manong.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 17:27
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Override
    public List<WCategory> queAllCate() {
        SqlSession sqlSession = MybatisUtil.mybatisTool(false);
        ICategoryDao cateDao = sqlSession.getMapper(ICategoryDao.class);
        List<WCategory> wCategories = cateDao.queAllCate();
        return wCategories;
    }
}
