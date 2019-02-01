package Class;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    private static Connection con = null;
    public static Connection Connect() throws SQLException, ClassNotFoundException{
        String url = "jdbc:mysql://127.0.0.1:3306/web?user=Mora";
        String user = "Mora";
        String password = "Chaos1532";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password);
        return con;
    }
}
