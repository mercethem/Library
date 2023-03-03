import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Borrow {
    static void borrow() {
        //Delete a student
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter ID number of Student : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter want to borrow ID Number of Book : ");
        long bookId = keyboard.nextLong();
        keyboard.nextLine();
        DateTimeFormatter currentDate = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Brought date
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime later = LocalDateTime.from(now).plusDays(30); //Return date
        try {//Database layer function and SQL query
            DataBaseLayer.dataBaseLayer(); //Database layer function and SQL query
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery
                    ("INSERT INTO LibraryStock.dbo.borrows (studentId,bookId,takenDate,broughtDate ) " +
                            "VALUES ('" + studentId + "', '" + bookId + "','" + currentDate.format(now) + "','"+currentDate.format(later)+"')"+
                            "UPDATE LibraryStock.dbo.books SET amount =  amount - '1' WHERE bookId = '"+bookId+"'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }
}


