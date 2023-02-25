import java.sql.*;

public class DataBaseLayer {
    static Connection myConnection;
    static String url = "jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;"; // table details
    public static Connection dataBaseLayer() {
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Driver name
        myConnection = DriverManager.getConnection(url);
    }
        catch (Exception e){
            System.out.println("Connection is failed!");
        }
        return myConnection;
    }
}
