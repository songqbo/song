package com.manong.dao;

import com.manong.util.JDBCUntil;
import jdk.nashorn.internal.ir.ReturnNode;
import oracle.jdbc.OracleTypes;
import java.sql.*;
import java.util.ArrayList;


/*
     dao类
    */
public class empFunDao {

       //1、调用函数，通过id查询姓名
       public String getNameByIdFun(int eno){
           //接收名字
           String name = null;
           //连接数据库
           Connection conn = JDBCUntil.getconnection();
           //sql语句
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

       //2、调用存储过程，通过id查询名字
       public String getNamePro(int eid){
           String name = null;
           //连接
           Connection conn = JDBCUntil.getconnection();
           //sql语句
           String sql  = "{call pro_emp1_name(?,?)}";

           try {
               CallableStatement call = conn.prepareCall(sql);
               //第一个输入参数
               call.setInt(1,eid);
               //第二个输出参数，要做注册说明
               call.registerOutParameter(2,Types.LONGVARCHAR);
               //执行
               call.executeQuery();
               //获取到第二个参数
               name = call.getString(2);
           } catch (Exception throwables) {
               throwables.printStackTrace();
           }
           return name;
       }


       //3、调用存储过程，查询输入的工资区间内的员工信息
       public ArrayList getEmpInfoPro(int min,int max) {
           //连接
           Connection conn = JDBCUntil.getconnection();
           //sql语句
           String sql = "{call emp_sal_test.pro_emp_info(?,?,?)}";

           try {
               CallableStatement call = conn.prepareCall(sql);
               //给第一?赋值
               call.setInt(1, min);
               //给第二?赋值
               call.setInt(2, max);
               //给第三?赋值，做注册说明
               call.registerOutParameter(3, OracleTypes.CURSOR);
               //执行
               call.execute();
               //用result转化接收获得的值
               ResultSet rs = (ResultSet) call.getObject(3);

               while (rs.next()) {
                   int eid = rs.getInt("empno");
                   String ename = rs.getString("ename");
                   double sal = rs.getDouble("sal");
                   System.out.println("编号为：" + eid + "名字为：" + ename + "工资为：" + sal);
               }

           } catch (Exception throwables) {
               throwables.printStackTrace();
           }
           return  null;
        }


}
