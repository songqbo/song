package com.manong.dao;

import com.manong.entity.WCategory;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 16:22
 */
public interface ICategoryDao {

    //����id��ѯ���
    @Select("select * from t_Wcategory where c_id = #{id}")
    @ResultMap("queCate")
    public WCategory queCateById(int id);

    //��ѯ�������
    @Select("select * from t_Wcategory")
    @ResultMap("queCate")
    public List<WCategory> queAllCate();
}
