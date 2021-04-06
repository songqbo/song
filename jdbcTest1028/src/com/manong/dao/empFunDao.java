package com.manong.dao;

import com.manong.util.JDBCUntil;
import jdk.nashorn.internal.ir.ReturnNode;
import oracle.jdbc.OracleTypes;
import java.sql.*;
import java.util.ArrayList;


/*
     dao��
    */
public class empFunDao {

       //1�����ú�����ͨ��id��ѯ����
       public String getNameByIdFun(int eno){
           //��������
           String name = null;
           //�������ݿ�
           Connection conn = JDBCUntil.getconnection();
           //sql���
           String sql = "select fun_emp_name(?) myname from dual";
           PreparedStatement pstm  = null;
           ResultSet rs = null;

           try {
               pstm = conn.prepareStatement(sql);
               pstm.setInt(1,eno);
               rs = pstm.executeQuery();
               if (rs.next()){
                    name = rs.getString(1);
               }
           } catch (Exception throwables) {
               throwables.printStackTrace();
           }finally {
               JDBCUntil.closeAll(conn,pstm,rs);
           }
           return name;
       }

       //2�����ô洢���̣�ͨ��id��ѯ����
       public String getNamePro(int eid){
           String name = null;
           //����
           Connection conn = JDBCUntil.getconnection();
           //sql���
           String sql  = "{call pro_emp1_name(?,?)}";

           try {
               CallableStatement call = conn.prepareCall(sql);
               //��һ���������
               call.setInt(1,eid);
               //�ڶ������������Ҫ��ע��˵��
               call.registerOutParameter(2,Types.LONGVARCHAR);
               //ִ��
               call.executeQuery();
               //��ȡ���ڶ�������
               name = call.getString(2);
           } catch (Exception throwables) {
               throwables.printStackTrace();
           }
           return name;
       }


       //3�����ô洢���̣���ѯ����Ĺ��������ڵ�Ա����Ϣ
       public ArrayList getEmpInfoPro(int min,int max) {
           //����
           Connection conn = JDBCUntil.getconnection();
           //sql���
           String sql = "{call emp_sal_test.pro_emp_info(?,?,?)}";

           try {
               CallableStatement call = conn.prepareCall(sql);
               //����һ?��ֵ
               call.setInt(1, min);
               //���ڶ�?��ֵ
               call.setInt(2, max);
               //������?��ֵ����ע��˵��
               call.registerOutParameter(3, OracleTypes.CURSOR);
               //ִ��
               call.execute();
               //��resultת�����ջ�õ�ֵ
               ResultSet rs = (ResultSet) call.getObject(3);

               while (rs.next()) {
                   int eid = rs.getInt("empno");
                   String ename = rs.getString("ename");
                   double sal = rs.getDouble("sal");
                   System.out.println("���Ϊ��" + eid + "����Ϊ��" + ename + "����Ϊ��" + sal);
               }

           } catch (Exception throwables) {
               throwables.printStackTrace();
           }
           return  null;
        }


}
