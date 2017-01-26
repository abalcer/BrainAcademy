package com.brainacademy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/jdbc-test";
    private static final String USER = "root";
    private static final String PASS = "123";

    public static void main(String[] args) {

        List<Task> tasks = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql =
                "SELECT id, category, dueDate " +
                        "FROM Task " +
                        "WHERE category = ?";

        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "category1");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getLong("id"));
                task.setCategory(rs.getString("category"));
                task.setDueDate(rs.getDate("dueDate"));
                tasks.add(task);
                System.out.println(task.getId());
                System.out.println(task.getCategory());
                System.out.println(task.getDueDate());
            }
            rs.close();
        } catch (SQLException se) {
            //Handle errors for JDBC. I'll just throw a RuntimeException.
            throw new RuntimeException("error when executing query", se);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
