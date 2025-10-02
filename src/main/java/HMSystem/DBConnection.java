package HMSystem;
import java.sql.*;


public class DBConnection {
    public static Connection getConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/HospitalDB";
            String user = "root";
            String pw = "abcd1234";
            return DriverManager.getConnection(url, user, pw);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }

    }
}
