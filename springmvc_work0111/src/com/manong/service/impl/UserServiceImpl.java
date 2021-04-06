package com.manong.service.impl;

import com.manong.dao.IUserDao;
import com.manong.entity.WUser;
import com.manong.service.UserService;
import com.manong.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 12:03
 */

@Service
public class UserServiceImpl implements UserService {

    @Override
    public WUser login(String name, String pwd) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(false);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        WUser wUser = userDao.login(name, pwd);
        return wUser;
    }

    @Override
    public void updPwd(String pwd, int id) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        userDao.updPwd(pwd,id);
    }

}
