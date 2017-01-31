package com.brainacademy.jdbc;

import java.util.Arrays;
import java.util.List;

import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class Main {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/jdbc-test";
    private static final String USER = "root";
    private static final String PASS = "123";

    public static void main(String[] args) {
        Sql2o sql2o = new Sql2o(DB_URL, USER, PASS);
        String sql =
                "SELECT id, categoryId, dueDate " +
                        "FROM Task " +
                        "WHERE categoryId = :categoryId";

        try(Connection con = sql2o.open()) {
            List<Task> tasks = con.createQuery(sql)
                    .addParameter("categoryId", 1L)
                    .executeAndFetch(Task.class);

            System.out.println(Arrays.toString(tasks.toArray()));
        }
    }
}
