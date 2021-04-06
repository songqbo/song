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

    //��ѯ����ѧ�������Ӧ�༶
    @Select("select * from students")
    @ResultMap("queStu")
    public List<Students> queAllStu();

    //���ѧ��
    @Insert("insert into students values(seq_city.nextval,#{sname},#{ssex},#{sage},#{goods.gid})")
    public void addStu(Students students);

    //��������ѯѧ��
    @SelectProvider(type = StudentProvider.class,method = "queManyStu")
    @ResultMap("queStu")
    public List<Students> queManys(Map map);

    //����idɾ��ѧ��
    @Delete("delete from students where id=#{id}")
    public int delStu(int id);

    //��ѡɾ��
    @DeleteProvider(type = StudentProvider.class,method = "delManyStu")
    public int delManys(int[] mid);
}
