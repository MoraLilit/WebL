package Class;

import java.sql.*;
import java.util.ArrayList;

public class WorkWithDB {
    private static ArrayList<ArrayList> dataContact = null;
    public static String ff = "yes";
    public static ArrayList<ArrayList> getData() throws SQLException {
        if(dataContact!= null){
            return dataContact;
        }
        else {
            dataContact = new ArrayList<>(DataContact.getDataContact());
            return dataContact;
        }
    }

    public static void insertContact(String s, String t) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = Conn.Connect().prepareStatement("INSERT INTO `web`.`contact` (`idcontact`, `Name`, `Number`) VALUES (?, ?, ?)");
        pstm.setInt(1, dataContact.size()+1);
        pstm.setString(2, s);
        pstm.setString(3, t);
        pstm.executeUpdate();
        dataContact = null;
        ff = "yes";
    }

    public static void deleteContact(Integer f)throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = Conn.Connect().prepareStatement("Delete From `web`.`contact` where `idcontact` = ?");
        pstm.setInt(1, f);
        pstm.executeUpdate();
        dataContact = null;
        ff = "yes";
    }

}
