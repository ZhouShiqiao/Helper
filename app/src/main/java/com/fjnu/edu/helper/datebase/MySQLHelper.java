package com.fjnu.edu.helper.datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ZhouShiqiao on 2017/6/18 0018.
 */

public class MySQLHelper {
    private static final String REMOTE_IP = "139.199.174.96:3306";
    private static final String URL = "jdbc:mysql://" + REMOTE_IP + "/testDB";
    private static final String USER = "lin";
    private static final String PASSWORD = "lin";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            final String DRIVER_NAME = "com.mysql.jdbc.Driver";
            Class.forName(DRIVER_NAME);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            conn = null;
        } catch (SQLException e) {
            conn = null;
        }

        return conn;
    }
}
