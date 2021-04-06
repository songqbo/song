package com.manong.dao;

import com.manong.entity.Product1028;
import com.manong.util.JDBCUntil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
  dao��
 */
public class  Product1028Dao {

    /**
     * ���
     */
    public int add(Product1028 pro){
        //��������
        int result = 0;
        //�������ݿ�
        Connection conn = JDBCUntil.getconnection();
        //sql���
        String sql = "insert into Product1028 values(seq_product1028.nextval,?,?,?)";
        PreparedStatement pstm =  null ;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,pro.getPname());
            pstm.setDouble(2,pro.getPprice());
            //ʱ��
            java.sql.Date date  = new java.sql.Date(pro.getPtime().getTime());
            pstm.setDate(3, date);
            result = pstm.executeUpdate();

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return result;

    };
    /**
     * ɾ��
     */
    public int delete(int pid){
        //��������
        int result = 0;
        //�������ݿ�
        Connection conn = JDBCUntil.getconnection();
        //sql���
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
