package hu.aar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EventModel {

    public void saveEventToOwnCalendar(String name, LocalDate value, String description) throws SQLException {
        String sql = "select id from loggedinuser";
        PreparedStatement preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        int userid = rs.getInt(1);

        String sql2 = "select id from calendar where CALENDAR.ownerid = ?";
        PreparedStatement preparedStatement2 = DatabaseConnection.getConnection().prepareStatement(sql2);
            preparedStatement2.setInt(1, userid);
        rs = preparedStatement2.executeQuery();
        rs.next();
        int calendarid = rs.getInt(1);


        String sql3 = "insert into EVENT (NAME, DESCRIPTION, CALENDARID) values (?, ?, ?)";
        PreparedStatement preparedStatement3 = DatabaseConnection.getConnection().prepareStatement(sql3);
        preparedStatement3.setString(1,name);
        preparedStatement3.setString(2,description);
        preparedStatement3.setInt(3,calendarid);
        preparedStatement3.execute();
            //TODO fix start-end time not null

    }
}
