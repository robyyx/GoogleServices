package hu.aar;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentModel {

    public void saveDocumentToRootFolder(String name, String content) throws SQLException {
        String sqlSearchUserID = "select id from loggedinuser";
        PreparedStatement psID = DatabaseConnection.getConnection().prepareStatement(sqlSearchUserID);
        ResultSet rsID = psID.executeQuery();
        rsID.next();
        int userid = rsID.getInt(1);

        String sqlSearchUserRootFolder = "select id from folder where folder.ownerid = ? AND folder.ROOTFOLDERID IS NULL";
        PreparedStatement psRFID = DatabaseConnection.getConnection().prepareStatement(sqlSearchUserRootFolder);
        psRFID.setInt(1,userid);
        ResultSet rsRFID = psRFID.executeQuery();
        rsRFID.next();
        int rootfolderid = rsRFID.getInt(1);

        String sqlInsertDocumentToRootFolder = "insert into document (OWNERID, FOLDERID, CONTENT, NAME) values (?,?,?,?)";
        System.out.println(userid + " " + rootfolderid + " " + name + " " + content);
        PreparedStatement psIDRF = DatabaseConnection.getConnection().prepareStatement(sqlInsertDocumentToRootFolder);
            psIDRF.setInt(1,userid);
            psIDRF.setInt(2,rootfolderid);
            psIDRF.setString(3,content);
            psIDRF.setString(4,name);
            psIDRF.execute();
    }

    public void loadDocument(TextField textFieldDocumentName, TextArea textAreaDocumentContent) throws SQLException {
        String sqlSearchUserID = "select id from loggedinuser";
        PreparedStatement psID = DatabaseConnection.getConnection().prepareStatement(sqlSearchUserID);
        ResultSet rsID = psID.executeQuery();
        rsID.next();
        int userid = rsID.getInt(1);

        String sqlSearchDocument = "select NAME, CONTENT from DOCUMENT where DOCUMENT.OWNERID = ?";
        PreparedStatement psSD = DatabaseConnection.getConnection().prepareStatement(sqlSearchDocument);
        psSD.setInt(1,userid);
        ResultSet rsSD = psSD.executeQuery();
        if(rsSD.next()){
            rsSD.next();
            textFieldDocumentName.setText(rsSD.getString(1));
            textAreaDocumentContent.setText(rsSD.getString(2));
        }

    }
}
