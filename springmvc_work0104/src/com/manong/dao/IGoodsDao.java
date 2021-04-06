package com.manong.dao;

import com.manong.entity.Goods;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/4 16:44
 */
public interface IGoodsDao {

    //查询所有
    @Select("select * from goods")
    @ResultMap("queGoods")
    public List<Goods> queAllGoods();

    //根据id做查询
    @Select("select * from goods where id=#{id}")
    @ResultMap("queGoods")
    public Goods queById(int id);

    //根据id做修改
    @Update("update goods set name=#{gname},address=#{gaddress},peoples=#{gpeoples} where id=#{gid}")
    public void updGoods(Goods goods);

    //添加
    @Insert("insert into goods values(seq_city.nextval,#{gname},#{gaddress},#{gpeoples})")
    public void addGood(Goods goods);

    //得到宿舍名称
    @Select("select * from goods")
    @ResultMap("queGoods")
    public List<Goods> queGoodNames();
}
