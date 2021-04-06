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

    //��ѯ��������
    public List<Goods> queAllGoods();

    //����id����ѯ
    public Goods queById(int id);

    //����id���޸�
    public void updGoods(Goods goods);

    //���
    public void addGood(Goods goods);

    //��ѯ���еõ���������
    public List<Goods> queGoodNames();



}
