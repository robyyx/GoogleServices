package hu.aar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FolderModel {


    public void createFolder(String name) throws SQLException {
        String sql = "select id from loggedinuser";
        PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int userid = rs.getInt(1);

        String sql2 = "select id from FOLDER where ownerid = ? AND ROOTFOLDERID IS NULL";
        PreparedStatement preparedStatement2 = DatabaseConnection.getConnection().prepareStatement(sql2);
        preparedStatement2.setInt(1, userid);
        rs = preparedStatement2.executeQuery();
        rs.next();
        int rootfolderid = rs.getInt(1);

        String sql3 = "insert into folder (NAME, OWNERID, ROOTFOLDERID) values (?, ?, ?)";
        PreparedStatement preparedStatement3 = DatabaseConnection.getConnection().prepareStatement(sql3);
        preparedStatement3.setString(1,name);
        preparedStatement3.setInt(2,userid);
        preparedStatement3.setInt(3,rootfolderid);
        preparedStatement3.execute();
    }
}
