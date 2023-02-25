import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayOptions {

    static void displayOptions() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What do you want to display ? " +
                "\nDisplay Account ? (0) \nDisplay Book ? (1)");
        byte options = keyboard.nextByte();
        switch (options) {
            case 0:
                DisplayAccount.displayAccount();
            case 1:
                DisplayBook.displayBookOptions();
        }
    }
}

class DisplayAccount {
    static void displayAccount() throws SQLException {
        DataBaseLayer.dataBaseLayer();
        Statement myStatement = DataBaseLayer.myConnection.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students,LibraryStock.dbo.borrows,LibraryStock.dbo.books WHERE students.studentId = borrows.studentId AND borrows.bookId=books.bookId ");
        while (myResult.next()) {

            System.out.printf("\nStudent ID: %s\nName Surname: %s\nFaculty: %s\nDepartment: %s\nClass: %s \nBirthdate: %s\nGender: %s ",
                    myResult.getString("studentId"), myResult.getString("nameSurname"),
                    myResult.getString("faculty"), myResult.getString("department"), myResult.getString("class"),
                    myResult.getString("birthDate").substring(0, 2) + "/" + myResult.getString("birthDate").substring(3, 5) + "/" + myResult.getString("birthDate").substring(6, 10),
                    myResult.getString("gender"));



        }
        System.out.printf("Book : %s = %s", myResult.getString("name"),myResult.getString("broughtDate"));
        myStatement.close(); // close statement
        DataBaseLayer.myConnection.close(); // close connection
    }
}

class DisplayBook {
    static void displayBookOptions() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What are you want to display with ? \nWith Book Id? (0): \nWith Book Name?(1)"
                + "\nWith Author Name? \n ");
        byte options = keyboard.nextByte();
        switch (options) {
            case 0:
                displayOptionsWithBookId();
            case 1:
                displayOptionsWithBookName();
            case 2:
                displayOptionsWithAuthorname();
        }
    }

    static void displayOptionsWithBookId() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a Book ID for display to book : ");
        long bookId = keyboard.nextLong();

    }

    static void displayOptionsWithBookName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter book name for display that book : ");
        String bookName = keyboard.nextLine();
        keyboard.next();

    }

    static void displayOptionsWithAuthorname() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter author name for display author's information and books : ");
        String authorName = keyboard.nextLine();
        keyboard.next();

    }
}