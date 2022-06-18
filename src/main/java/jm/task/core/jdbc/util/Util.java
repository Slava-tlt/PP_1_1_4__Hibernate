package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {

    private static final String DB_DRIVER ="com.mysql.jdbc.Driver";
    private static final String DB_URL ="jdbc:mysql://localhost:3306/test1";
    private static final String DB_USERNAME ="root";
    private static final String DB_PASSWORD ="root";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }
}
