package com.manong.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Description:
 * mybatis������
 * @Author SQB
 * @Date 2020/11/30 18:28
 */
public class MybatisUtil {
    private static SqlSessionFactory build;

    static{
        try {
            //�������������ļ�
            InputStream ra = Resources.getResourceAsStream("mybatis-config.xml");
            //��ȡ���ݿ����
            build = new SqlSessionFactoryBuilder().build(ra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession mybatisTool(boolean trancation){
        //�������ݿ��������
        return  build.openSession(trancation);
    }
}
