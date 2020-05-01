package hu.aar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "robi";
        String dbpw = "12345";
        return DriverManager.getConnection(url, user, dbpw);
    }
}
