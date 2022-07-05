package com.ultraneos.mall.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Saitama
 * @since 2022/06/28 11:52
 */

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream("mybatis.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        sqlSessionFactory = sqlSessionFactoryBuilder.build(stream);

    }

    public static SqlSession getSqlSession(){ return sqlSessionFactory.openSession();}
}
