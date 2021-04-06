package com.manong.service;

import com.manong.entity.Students;
import com.manong.provider.StudentProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 22:36
 */
public interface IStudentsService {

    //��ѯѧ��
    public List<Students> queAllStu();

    //���ѧ��
    public void addStu(Students students);

    //��������ѯ
    public List<Students> queManys(Map map);

    //����idɾ��ѧ��
    public int  delStu(int id);

    //��ѡɾ��
    public int delManys(int[] mid);


}
