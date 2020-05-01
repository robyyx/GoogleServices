package hu.aar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    public boolean loginUser(String email, String password) throws SQLException {
        String sql = "SELECT id FROM users WHERE users.email = ? AND users.password = ?";
        PreparedStatement prepareStatement = DatabaseConnection.getConnection().prepareStatement(sql);
        prepareStatement.setString(1, email);
        prepareStatement.setString(2, password);
        ResultSet resultset = prepareStatement.executeQuery();

        return resultset.next();
    }
}
