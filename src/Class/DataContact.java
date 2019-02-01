package Class;


import java.sql.*;
import java.util.ArrayList;

public class DataContact {
    public static ArrayList<ArrayList> data = new ArrayList();
    public static ResultSet rs;
    private static Statement stmt;

    public static ArrayList<ArrayList> getDataContact() throws SQLException {
        data.clear();
        try {
            stmt = Conn.Connect().createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        rs = stmt.executeQuery("SELECT * FROM `web`.`contact`");
        rs.last();
        int rows_count = rs.getRow();
        rs.first();
        for(int row =0; row < rows_count;row++){
            data.add(new ArrayList());
            for(int column =0; column < 3;column++){
                data.get(row).add(rs.getString(column+1));
            }
            rs.next();
        }
        stmt.close();
        rs.close();
        return data;
    }
}
