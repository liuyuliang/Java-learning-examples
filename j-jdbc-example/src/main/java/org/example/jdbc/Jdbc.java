package org.example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * ClassName: Jdbc
 * Description:
 *
 * @author Yuliang Lau
 * @date 2023/9/4 16:50
 */
public class Jdbc {
    public Connection getJdbcConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //读取配置文件
        PropertyResourceBundle prb = (PropertyResourceBundle) ResourceBundle.getBundle("jdbc");
        String driverClassName = prb.getString("driverClassName");
        String url = prb.getString("url");
        String username = prb.getString("username");
        String password = prb.getString("password");
        Class.forName(driverClassName).newInstance();
        Connection conn = DriverManager.getConnection(url, username,
                password);
        return conn;
    }
}
