package com.manong.service;

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
 * @Date 2021/1/4 16:49
 */
public interface IGoodsService {

    //查询所有寝室
    public List<Goods> queAllGoods();

    //根据id做查询
    public Goods queById(int id);

    //根据id做修改
    public void updGoods(Goods goods);

    //添加
    public void addGood(Goods goods);

    //查询所有得到宿舍名称
    public List<Goods> queGoodNames();



}
