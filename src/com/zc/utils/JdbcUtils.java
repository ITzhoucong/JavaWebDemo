package com.zc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @auther: ZhouCong
 * @date: Create in 2019/7/28 15:21
 * @description:
 */
public class JdbcUtils {
    private static DataSource ds;

    static {
        Properties properties = new Properties();

        InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            properties.load(inputStream);
            ds = DruidDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * 功能描述: 获取连接池对象
     *
     * @Param: []
     * @Return: javax.sql.DataSource
     * @Author: ZhouCong
     * @Date: 2019/7/28 15:36
     */
    public static DataSource getDataSource(){
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
