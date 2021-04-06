package com.manong.dao;

import com.manong.entity.WUser;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/11 12:05
 */
public interface IUserDao {

    //µÇÂ¼
    @Select("select * from t_Wuser where u_name= #{0} and u_pwd = #{1}")
    @ResultMap("queUser")
    public WUser login(String uname, String upwd);

    //ÐÞ¸ÄÃÜÂë
    @Update("update t_Wuser set u_pwd = #{0} where  u_id=#{1}")
    public void updPwd(String pwd,int id);
}
