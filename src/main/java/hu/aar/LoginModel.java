package hu.aar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel {

    public boolean loginUser(String email, String password) throws SQLException {
        String sql = "SELECT id, NAME FROM users WHERE users.email = ? AND users.password = ?";
        PreparedStatement prepareStatement = DatabaseConnection.getConnection().prepareStatement(sql);
        prepareStatement.setString(1, email);
        prepareStatement.setString(2, password);
        ResultSet resultset = prepareStatement.executeQuery();
        if(resultset.next()){
            int userid = resultset.getInt(1);
            System.out.println(userid);
            String username = resultset.getString(2);
            System.out.println(username);
            String sqlEmptyLoggedinuser = "DELETE FROM LOGGEDINUSER";
            PreparedStatement prepareStatement2 = DatabaseConnection.getConnection().prepareStatement(sqlEmptyLoggedinuser);
            prepareStatement2.execute();
            String sqlInsertLoggedinuser = "insert into LOGGEDINUSER (ID, USERNAME) VALUES (?, ?)";
            PreparedStatement prepareStatement3 = DatabaseConnection.getConnection().prepareStatement(sqlInsertLoggedinuser);
            prepareStatement3.setInt(1, userid);
            prepareStatement3.setString(2, username);
            prepareStatement3.execute();

            return true;
        }
        return false;
    }
}
