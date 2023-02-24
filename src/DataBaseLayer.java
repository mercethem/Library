import java.sql.*;

public class DataBaseLayer {


    static void dataBaseLayer() throws SQLException, ClassNotFoundException {
      /*  Connection c = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
        Statement st = c.createStatement();

        String query = "SELECT * FROM LibraryStock.dbo.students WHERE studentId";
        PreparedStatement pt = c.prepareStatement(query);
        //pt.setInt(2,);
        //pt.setString();
        //pt.executeUpdate();
        System.out.println(pt);
*/

      /*  try {
            Connection myConnection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-T9F59R5\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;");
            Statement myStmt = myConnection.createStatement();
            ResultSet myQuery = myStmt.executeQuery("SELECT * FROM LibraryStock.dbo.students");
            while (myQuery.next()){
                System.out.printf("\nStudent ID: %s\nName Surname: %s\nFaculty: %s\nDepartment: %s\nClass: %s \nBirthdate: %s\nGender: %s \n",
                        myQuery.getString("studentId"), myQuery.getString("nameSurname"),
                        myQuery.getString("faculty"), myQuery.getString("department"), myQuery.getString("class")
                        , myQuery.getString("birthDate").substring(0,2)+"/"+myQuery.getString("birthDate").substring(3,5)+"/"+myQuery.getString("birthDate").substring(6,10), myQuery.getString("gender"));
            }
        } catch (Exception e) {
            System.out.println(e);

        }*/
        String url = "jdbc:sqlserver://DESKTOP-T9F59R5\\\\MSSQLSERVER:1433;useSSL=false;encrypt=false;integratedSecurity=true;"; // table details
        String myQuery = "SELECT * FROM LibraryStock.dbo.students"; // query to be run
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // Driver name
        Connection con = DriverManager.getConnection(url);
        System.out.println("Connection Established successfully");
        Statement st = con.createStatement();
        ResultSet rs= st.executeQuery(myQuery); // Execute query
        rs.next();
        //String studentId= rs.getString("studentId"); // Retrieve name from db
        String studentId = rs.getString("studentId")+"\n"+ rs.getString("nameSurname")+"\n"+
                rs.getString("faculty")+"\n"+ rs.getString("department")+"\n"+ rs.getString("class")
                +"\n"+ rs.getString("birthDate").substring(0,2)+"/"+rs.getString("birthDate").substring(3,5)+"/"+rs.getString("birthDate").substring(6,10)
                +"\n"+ rs.getString("gender");

        System.out.println(studentId); // Print result on console
        st.close(); // close statement
        con.close(); // close connection
        System.out.println("Connection Closed....");

    }
}
