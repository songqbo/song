package com.manong.test;

import com.manong.dao.Product1028Dao;
import com.manong.dao.empFunDao;
import com.manong.entity.Product1028;
import java.util.Date;
/*
  ������
 */
public class test1028 {

    public static void main(String[] args) {
     /*   Product1028 pro = new Product1028(0, "����", 12.9, new Date());
        //���������
        int result = new Product1028Dao().add(pro);
        System.out.println(result);
        */
        /*new Product1028Dao().delete(2);*/

        //���ú���
        /*String name  = new empFunDao().getNameByIdFun(7369);
        System.out.println(name);*/

        //���ô洢����
       /* String name  = new empFunDao().getNamePro(7369);
        System.out.println(name);*/

        //�鿴��������Ա����Ϣ
        new empFunDao().getEmpInfoPro(500,1500);
    }
}
