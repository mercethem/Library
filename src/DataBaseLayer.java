import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseLayer {
    static Connection myConnection;
    static String url = "jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQL SERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;"; // Database URL

    public static void dataBaseLayer() { //Database layer function
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Driver name
            myConnection = DriverManager.getConnection(url);
            System.out.println("Connections is successful!");
        } catch (Exception e) {
            System.out.println("Connection is failed!");
        }
    }
}
