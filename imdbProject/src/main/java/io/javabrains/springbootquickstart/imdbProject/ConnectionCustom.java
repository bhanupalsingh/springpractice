package io.javabrains.springbootquickstart.imdbProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCustom {

    private final String url = "jdbc:postgresql://localhost:5432/SpringTest";
    private final String user = "postgres";
    private final String password = "postgres";
 
    public Connection connect() {
        Connection conn = null;
        try {
            conn =  DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
 
        return conn;
    }
}
