package com.manong.test;

import com.manong.dao.Product1028Dao;
import com.manong.dao.empFunDao;
import com.manong.entity.Product1028;
import java.util.Date;
/*
  测试类
 */
public class test1028 {

    public static void main(String[] args) {
     /*   Product1028 pro = new Product1028(0, "西瓜", 12.9, new Date());
        //调用添加类
        int result = new Product1028Dao().add(pro);
        System.out.println(result);
        */
        /*new Product1028Dao().delete(2);*/

        //调用函数
        /*String name  = new empFunDao().getNameByIdFun(7369);
        System.out.println(name);*/

        //调用存储过程
       /* String name  = new empFunDao().getNamePro(7369);
        System.out.println(name);*/

        //查看工资区间员工信息
        new empFunDao().getEmpInfoPro(500,1500);
    }
}
