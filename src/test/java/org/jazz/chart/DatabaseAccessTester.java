package org.jazz.chart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This class is just for trouble-shooting your DB connection.
 */
public class DatabaseAccessTester
{
    public static void main(String[] args)
    {
        testJdbcAccess();
    }

    public static void testJdbcAccess()
    {
        String url = "jdbc:postgresql://192.168.99.100/project";  // because of Docker, on unix systems, just use localhost
        Properties props = new Properties();
        props.setProperty("user", "admin");
        props.setProperty("password", "password");
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, props);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT 1");
            while (rs.next()) {
                long id = rs.getLong(1);
                System.out.println("IDid");
            }
            System.out.println("Done");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}