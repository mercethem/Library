import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseLayer {
    static Connection myConnection;
    static String url = "jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;"; // Database URL

    public static Connection dataBaseLayer() { //Database layer function
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Driver name
            myConnection = DriverManager.getConnection(url);
        } catch (Exception e) {
            System.out.println("Connection is failed!");
        }
        return myConnection;
    }
}
