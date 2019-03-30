package com.qianfeng.fxmall.commons.mybotis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 恶汉单例
 */
public class MyBatisSessionFactoryUtils {
    public  static SqlSessionFactory sqlSessionFactory;
    private static  SqlSession sqlSession;
    static {
        initSessionFactory();
    }
    private  static void initSessionFactory(){
        try {
            //1配置文件只需要加载一次(全局)
            InputStream inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
            //2全局唯一
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static  SqlSessionFactory getSqlSessionFactory(){
        if(sqlSessionFactory ==null) {
            initSessionFactory();
        }
        return sqlSessionFactory;
    }

public  static SqlSession getSession(){
    if (sqlSession == null){
        sqlSession =sqlSessionFactory.openSession();
    }
   return sqlSessionFactory.openSession();
}


}
