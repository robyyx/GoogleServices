package hu.aar;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DocumentModel {

    public void saveDocumentToRootFolder(String name, String content) throws SQLException {
        //get and set current user's id
        String sqlSearchUserID = "select id from loggedinuser";
        PreparedStatement psID = DatabaseConnection.getConnection().prepareStatement(sqlSearchUserID);
        ResultSet rsID = psID.executeQuery();
        rsID.next();
        int userid = rsID.getInt(1);

        //get and set the rootfolderid
        String sqlSearchUserRootFolder = "select id from folder where folder.ownerid = ? AND folder.ROOTFOLDERID IS NULL";
        PreparedStatement psRFID = DatabaseConnection.getConnection().prepareStatement(sqlSearchUserRootFolder);
        psRFID.setInt(1,userid);
        ResultSet rsRFID = psRFID.executeQuery();
        rsRFID.next();
        int rootfolderid = rsRFID.getInt(1);

        //is this document name already taken by you in this folder?
        String sqlSearchForSameNameDocument = "select count(ID) from DOCUMENT where NAME = ? AND OWNERID = ? AND FOLDERID = ?";
        PreparedStatement psSSND = DatabaseConnection.getConnection().prepareStatement(sqlSearchForSameNameDocument);
        psSSND.setString(1, name);
        psSSND.setInt(2, userid);
        psSSND.setInt(3, rootfolderid);
        ResultSet rsSSND = psSSND.executeQuery();
        if(rsSSND.next());

        if(rsSSND.getInt(1) != 0){
            String sqlUpdateDocument = "update DOCUMENT set CONTENT = ? where OWNERID = ? AND FOLDERID = ? AND NAME = ?";
            PreparedStatement psUD = DatabaseConnection.getConnection().prepareStatement(sqlUpdateDocument);
            psUD.setString(1, content);
            psUD.setInt(2, userid);
            psUD.setInt(3, rootfolderid);
            psUD.setString(4, name);
            psUD.execute();
        } else{
            //insert the document into the database if new
            String sqlInsertDocumentToRootFolder = "insert into document (OWNERID, FOLDERID, CONTENT, NAME) values (?,?,?,?)";
            System.out.println(userid + " " + rootfolderid + " " + name + " " + content);
            PreparedStatement psIDRF = DatabaseConnection.getConnection().prepareStatement(sqlInsertDocumentToRootFolder);
            psIDRF.setInt(1,userid);
            psIDRF.setInt(2,rootfolderid);
            psIDRF.setString(3,content);
            psIDRF.setString(4,name);
            psIDRF.execute();
        }
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
            textFieldDocumentName.setText(rsSD.getString(1));
            textAreaDocumentContent.setText(rsSD.getString(2));
        }
    }
}
