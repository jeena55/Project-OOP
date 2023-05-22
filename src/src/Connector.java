
import java.sql.*;

public class Connector {

    public static Connection mycon() {
        String url = "jdbc:mysql://localhost/project";
        String username = "root";
        String password = "0631174147";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        }
    }
}
