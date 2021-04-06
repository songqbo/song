package com.manong.dao;

import com.manong.entity.Product1028;
import com.manong.util.JDBCUntil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
  dao类
 */
public class  Product1028Dao {

    /**
     * 添加
     */
    public int add(Product1028 pro){
        //返回行数
        int result = 0;
        //连接数据库
        Connection conn = JDBCUntil.getconnection();
        //sql语句
        String sql = "insert into Product1028 values(seq_product1028.nextval,?,?,?)";
        PreparedStatement pstm =  null ;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,pro.getPname());
            pstm.setDouble(2,pro.getPprice());
            //时间
            java.sql.Date date  = new java.sql.Date(pro.getPtime().getTime());
            pstm.setDate(3, date);
            result = pstm.executeUpdate();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return result;

    };
    /**
     * 删除
     */
    public int delete(int pid){
        //返回行数
        int result = 0;
        //连接数据库
        Connection conn = JDBCUntil.getconnection();
        //sql语句
        String sql = "delete from Product1028 where p_id = ?";
        PreparedStatement pstm = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1,pid);
            result = pstm.executeUpdate();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

}
