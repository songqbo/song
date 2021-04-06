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

    //查询学生
    public List<Students> queAllStu();

    //添加学生
    public void addStu(Students students);

    //多条件查询
    public List<Students> queManys(Map map);

    //根据id删除学生
    public int  delStu(int id);

    //多选删除
    public int delManys(int[] mid);


}
