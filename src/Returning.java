import java.sql.Statement;
import java.util.Scanner;

public class Returning {//Want to return book ?

    static void returning() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter ID number of Student : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter ID number of Book : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter want to borrow ID Number of borrow : ");
        long borrowId = keyboard.nextLong();
        keyboard.nextLine();
        try {//Database layer function and SQL query
            DataBaseLayer.dataBaseLayer(); //Database layer function and SQL query
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery
                    ("DELETE FROM LibraryStock.dbo.borrows WHERE studentId = '"+studentId+"' AND borrowId = '" + borrowId + "'"+
                            "UPDATE LibraryStock.dbo.books SET amount =  amount + '1' WHERE bookId = '"+bookId+"'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }

    }
}