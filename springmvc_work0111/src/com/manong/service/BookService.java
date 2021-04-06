package com.manong.service;

import com.manong.entity.WBook;
import org.apache.ibatis.annotations.Delete;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 16:03
 */
public interface BookService {

     //查询所有图书
     public List<WBook> queAllBook();

     //添加图书
     public void addBook(WBook wBook);

     //根据id做删除
     public int delBook(int id);
}
