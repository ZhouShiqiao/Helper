package com.fjnu.edu.helper.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ZhouShiqiao on 2017/6/18 0018.
 */

public class MySQLHelper {
    private static  String url = "jdbc:mysql://139.199.174.96:3306/testDB";
    private static  String name = "com.mysql.jdbc.Driver";
    private static  String user = "lin";
    private static  String password = "lin";

    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(name);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return conn;
    }
}
