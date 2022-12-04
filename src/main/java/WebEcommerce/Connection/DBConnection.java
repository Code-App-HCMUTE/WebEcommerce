package WebEcommerce.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DBConnection {
    Connection connection;
    public Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection =DriverManager.getConnection("jdbc:mysql://localhost:3306/economies","root","0908218507");
        return connection;
    }
    public static void main(String[] args) {
        try {
            System.out.println(new DBConnection().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
