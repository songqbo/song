package com.manong.dao;

import com.manong.entity.Users;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
/**
 * Description:
 *
 * @Author SQB
 * @Date 2021/1/6 10:30
 */

public interface IUserDao {

    @Select("select * from users where name = #{0} and pwd = #{1}")
    @ResultMap("queUsers")
    public Users queUsers(String names,String pwd);
}
