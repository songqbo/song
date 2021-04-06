package com.manong.service.impl;

import com.manong.dao.IStudentsDao;
import com.manong.entity.Students;
import com.manong.service.IStudentsService;
import com.manong.util.MybatisUtil;
import com.sun.xml.internal.ws.addressing.WsaTubeHelper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 22:37
 */
@Service
public class IStudentsServiceImpl implements IStudentsService {

    //查询所有学生
    @Override
    public List<Students> queAllStu() {
        SqlSession sqlSession = MybatisUtil.mybatisTool(false);
        IStudentsDao stuDao = sqlSession.getMapper(IStudentsDao.class);
        List<Students> students = stuDao.queAllStu();
        return students;
    }

    //添加
    @Override
    public void addStu(Students students) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IStudentsDao stuDao = sqlSession.getMapper(IStudentsDao.class);
        stuDao.addStu(students);
    }

    //多条件查询
    @Override
    public List<Students> queManys(Map map) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IStudentsDao stuDao = sqlSession.getMapper(IStudentsDao.class);
        List<Students> students = stuDao.queManys(map);
        System.out.println(map.get("names"));
        return students;
    }

    //删除学生
    @Override
    public int delStu(int id) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IStudentsDao stuDao = sqlSession.getMapper(IStudentsDao.class);
        int count = stuDao.delStu(id);
        return count;
    }

    //多选删除
    public int delManys(int[] mid) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IStudentsDao stuDao = sqlSession.getMapper(IStudentsDao.class);
        return stuDao.delManys(mid);
    }
}
