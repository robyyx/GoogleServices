package hu.aar;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class RegistrationModel {

    public void createUser(String email, String name, String password) throws SQLException {
        String sql = "insert into USERS (EMAIL, NAME, PASSWORD) VALUES (?, ?, ?)";
        PreparedStatement prepareStatement = DatabaseConnection.getConnection().prepareStatement(sql);
            prepareStatement.setString(1, email);
            prepareStatement.setString(2, name);
            prepareStatement.setString(3, password);
            prepareStatement.execute();


            prepareStatement.close();
    }
}
