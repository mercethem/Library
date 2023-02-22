import java.sql.*;

public class DataBaseLayer {


    public void dataBaseLayer() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;database=LibraryStock;useSSL=false;encrypt=false;integratedSecurity=true;");
        Statement st = c.createStatement();

        /*String query = "...";
        PreparedStatement pt = c.prepareStatement(query);
        pt.setInt(2,);
        pt.setString(1,);
        pt.executeUpdate();
        */

    }
}
