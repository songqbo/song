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


    //查询所有书籍
    @Select("select * from t_Wbook")
    @ResultMap("queBook")
    public List<WBook> queAllBook();

    //添加书籍
    @Insert("insert into t_Wbook values(seq_Wbook.Nextval,#{bname},#{bauthor},#{bprice},#{wCategory.cid},#{bpicname},#{bpictime})")
    public void addBook(WBook wBook);

    //根据id做删除
    @Delete("delete from t_Wbook where b_id = #{id}")
    public int delBook(int id);
}
