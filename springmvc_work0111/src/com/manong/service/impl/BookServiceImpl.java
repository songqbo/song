package com.manong.service.impl;

import com.manong.dao.IBookDao;
import com.manong.entity.WBook;
import com.manong.service.BookService;
import com.manong.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 16:04
 */
@Service
public class BookServiceImpl implements BookService {

    //查询书籍
    @Override
    public List<WBook> queAllBook() {
        SqlSession sqlSession = MybatisUtil.mybatisTool(false);
        IBookDao bookDao = sqlSession.getMapper(IBookDao.class);
        List<WBook> wBooks = bookDao.queAllBook();
        return wBooks;
    }

    //添加书籍
    @Override
    public void addBook(WBook wBook) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IBookDao bookDao = sqlSession.getMapper(IBookDao.class);
        bookDao.addBook(wBook);
    }

    //删除书籍
    @Override
    public int delBook(int id) {
        SqlSession sqlSession = MybatisUtil.mybatisTool(true);
        IBookDao bookDao = sqlSession.getMapper(IBookDao.class);
        int num = bookDao.delBook(id);
        return num;
    }

}
