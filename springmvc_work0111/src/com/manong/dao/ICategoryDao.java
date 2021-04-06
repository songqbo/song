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

    //根据id查询类别
    @Select("select * from t_Wcategory where c_id = #{id}")
    @ResultMap("queCate")
    public WCategory queCateById(int id);

    //查询所有类别
    @Select("select * from t_Wcategory")
    @ResultMap("queCate")
    public List<WCategory> queAllCate();
}
