package hu.aar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class registrationModel {

    public registrationModel() {

    }

    public void createUser(String email, String name, String password) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "robi";
        String dbpw = "12345";
        try {
            Connection myConn = DriverManager.getConnection(url, user, dbpw);
            //Statement myStmt = myConn.createStatement();
            //String sql = "insert into USERS (EMAIL, NAME, PASSWORD) VALUES ('" + email + "', '" + name + "', '" + password +"')";
            //ResultSet rs = myStmt.executeQuery(sql);
            String sql = "insert into USERS (EMAIL, NAME, PASSWORD) VALUES (?, ?, ?)";

            PreparedStatement prepareStatement = myConn.prepareStatement(sql);
            prepareStatement.setString(1, email);
            prepareStatement.setString(2, name);
            prepareStatement.setString(3, password);
            prepareStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
