package com.manong.dao;

import com.manong.entity.WBook;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 16:04
 */
public interface IBookDao {


    //��ѯ�����鼮
    @Select("select * from t_Wbook")
    @ResultMap("queBook")
    public List<WBook> queAllBook();

    //����鼮
    @Insert("insert into t_Wbook values(seq_Wbook.Nextval,#{bname},#{bauthor},#{bprice},#{wCategory.cid},#{bpicname},#{bpictime})")
    public void addBook(WBook wBook);

    //����id��ɾ��
    @Delete("delete from t_Wbook where b_id = #{id}")
    public int delBook(int id);
}
