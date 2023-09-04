package org.example.util;

/**
 * ClassName: D
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/4 17:17
 */


import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;


public class DataSourceUtils {

    private static DataSource dataSource;

    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();


    // 直接可以获取一个连接池
    public static DataSource getDataSource(Properties properties) {

        try {
//                properties.load(DataSourceUtils.class.getResourceAsStream("jdbc.properties"));
            dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        getDataSource(null);
        Connection con = tl.get();
        if (con == null) {
            con = dataSource.getConnection();
            tl.set(con);
        }
        return con;
    }

    // 开启事务
    public static void startTransaction() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.setAutoCommit(false);
        }
    }

    // 事务回滚
    public static void rollback() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.rollback();
        }
    }

    // 提交并且 关闭资源及从ThreadLocall中释放
    public static void commitAndRelease() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.commit(); // 事务提交
            con.close();// 关闭资源
            tl.remove();// 从线程绑定中移除
        }
    }

    // 关闭资源方法
    public static void closeConnection() throws SQLException {
        Connection con = getConnection();
        if (con != null) {
            con.close();
            tl.remove();// 从线程绑定中移除
        }
    }

    public static void closeStatement(Statement st) throws SQLException {
        if (st != null) {
            st.close();
        }
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

}
