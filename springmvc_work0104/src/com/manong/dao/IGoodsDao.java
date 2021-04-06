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

    //��ѯ����
    @Select("select * from goods")
    @ResultMap("queGoods")
    public List<Goods> queAllGoods();

    //����id����ѯ
    @Select("select * from goods where id=#{id}")
    @ResultMap("queGoods")
    public Goods queById(int id);

    //����id���޸�
    @Update("update goods set name=#{gname},address=#{gaddress},peoples=#{gpeoples} where id=#{gid}")
    public void updGoods(Goods goods);

    //���
    @Insert("insert into goods values(seq_city.nextval,#{gname},#{gaddress},#{gpeoples})")
    public void addGood(Goods goods);

    //�õ���������
    @Select("select * from goods")
    @ResultMap("queGoods")
    public List<Goods> queGoodNames();
}
