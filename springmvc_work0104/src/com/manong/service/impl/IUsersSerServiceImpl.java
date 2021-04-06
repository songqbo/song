package com.manong.service.impl;

import com.manong.dao.IUserDao;
import com.manong.entity.Users;
import com.manong.service.IUsersSerService;
import com.manong.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/6 10:31
 */

@Service
public class IUsersSerServiceImpl implements IUsersSerService {

    //根据用户名和密码查询
    @Override
    public Users queUsers(String names, String pwd) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(false);
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        Users users = userDao.queUsers(names, pwd);
        return users;
    }
}
