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

     //��ѯ����ͼ��
     public List<WBook> queAllBook();

     //���ͼ��
     public void addBook(WBook wBook);

     //����id��ɾ��
     public int delBook(int id);
}
