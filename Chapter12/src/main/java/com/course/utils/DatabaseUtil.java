package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {

    //创建能够执行申请了、语句是sqlSSion
    public  static SqlSession getSqlSession() throws IOException {
        //获取配置的资源文件
        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");
        //第二个把这个文件给buled出来，使用类加载器，加载配置文件。
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //sqlsession就是能够执行配置文件的sql语句了。
        SqlSession  sqlSession = factory.openSession();
        //然后返回回去
        return  sqlSession;
    }

}
