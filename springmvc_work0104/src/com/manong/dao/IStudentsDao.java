package com.manong.dao;

import com.manong.entity.Students;
import com.manong.provider.StudentProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 22:09
 */
public interface IStudentsDao {

    //查询所有学生及其对应班级
    @Select("select * from students")
    @ResultMap("queStu")
    public List<Students> queAllStu();

    //添加学生
    @Insert("insert into students values(seq_city.nextval,#{sname},#{ssex},#{sage},#{goods.gid})")
    public void addStu(Students students);

    //多条件查询学生
    @SelectProvider(type = StudentProvider.class,method = "queManyStu")
    @ResultMap("queStu")
    public List<Students> queManys(Map map);

    //根据id删除学生
    @Delete("delete from students where id=#{id}")
    public int delStu(int id);

    //多选删除
    @DeleteProvider(type = StudentProvider.class,method = "delManyStu")
    public int delManys(int[] mid);
}
