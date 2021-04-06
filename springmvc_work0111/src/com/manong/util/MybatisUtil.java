package com.manong.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Description:
 * mybatis工具类
 * @Author SQB
 * @Date 2020/11/30 18:28
 */
public class MybatisUtil {
    private static SqlSessionFactory build;

    static{
        try {
            //解析核心配置文件
            InputStream ra = Resources.getResourceAsStream("mybatis-config.xml");
            //获取数据库对象
            build = new SqlSessionFactoryBuilder().build(ra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession mybatisTool(boolean trancation){
        //返回数据库操作对象
        return  build.openSession(trancation);
    }
}
