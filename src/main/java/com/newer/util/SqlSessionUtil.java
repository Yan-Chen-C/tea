package com.newer.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author shining
 */
public class SqlSessionUtil {
    //用于连接数据库生产连接会话对象的工厂对象
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //读取主配置文件的输入流
            Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
            //加载配置文件，创建工厂对象
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取与数据库连接好的会话对象
     * SqlSession:mybatis版的connection+statement
     * @return
     */
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    /**
     * 关闭连接会话对象
     * @param sqlSession
     */
    public static void close(SqlSession sqlSession){
        if(sqlSession!=null){
            sqlSession.close();
        }
    }

}
