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
    static void displayAccount() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to view student ID number:");
        long studentId = keyboard.nextLong();

        DataBaseLayer.dataBaseLayer();
        Statement myStatement = DataBaseLayer.myConnection.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
        while (myResult.next()) {   //This section have 15 characters before from % for scheme
                System.out.println("ACCOUNT INFORMATIONS");
                System.out.print("--------------------");
                System.out.printf("\nStudent ID:    %d\nName Surname:  %S\nFaculty:       %S\nDepartment:    %S\nClass:         %d\nBirthdate:     %s\nGender:        %S\n",
                        myResult.getLong("studentId"), myResult.getString("studentNameSurname").trim(),
                        myResult.getString("faculty").trim(), myResult.getString("department").trim(), myResult.getInt("class"),
                        myResult.getString("birthDate").trim().substring(0, 2) + "/" + myResult.getString("birthDate").substring(3, 5) + "/" + myResult.getString("birthDate").substring(6, 10),
                        myResult.getString("gender").trim() + "\n");
        }


        Statement myStatement2 = DataBaseLayer.myConnection.createStatement();
        ResultSet myResult2 = myStatement2.executeQuery("SELECT * FROM LibraryStock.dbo.students,LibraryStock.dbo.borrows,LibraryStock.dbo.books WHERE students.studentId = '" + studentId + "' AND students.studentId = borrows.studentId AND borrows.bookId=books.bookId");
        System.out.println("BORROWED BOOKS");
        System.out.println("--------------");
        while (myResult2.next()) {   //This section have 15 characters before from % for scheme
            System.out.printf("Borrowed Book: %s => Author: %s ((Brought Date: %s\n", myResult2.getString("bookName").trim(), myResult2.getString("authorNameSurname").trim(),
                    myResult2.getString("broughtDate").trim().substring(0, 2) + "/" + myResult2.getString("broughtDate").substring(3, 5) + "/" + myResult2.getString("broughtDate").substring(6, 10) + "))");
        }
        System.out.println();
        myStatement.close(); // close statement
        DataBaseLayer.myConnection.close(); // close connection
        Menu.menu();
    }
}


class DisplayBook {
    static void displayBookOptions() throws SQLException {
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

    static void displayOptionsWithBookId() throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a Book ID for display to book : ");
        long bookId = keyboard.nextLong();

        DataBaseLayer.dataBaseLayer();
        Statement myStatement = DataBaseLayer.myConnection.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students,LibraryStock.dbo.borrows,LibraryStock.dbo.books WHERE students.studentId = '" + bookId + "' AND students.studentId = borrows.studentId AND borrows.bookId=books.bookId");



    }

    static void displayOptionsWithBookName() throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter book name for display that book : ");
        String bookName = keyboard.nextLine();
        keyboard.next();
        //TODO trim and lowercase etc.

        DataBaseLayer.dataBaseLayer();
        Statement myStatement = DataBaseLayer.myConnection.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students,LibraryStock.dbo.borrows,LibraryStock.dbo.books WHERE students.studentId = '" + bookName + "' AND students.studentId = borrows.studentId AND borrows.bookId=books.bookId");


    }

    static void displayOptionsWithAuthorname() throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter author name for display author's information and books : ");
        String authorName = keyboard.nextLine();
        keyboard.next();
        //TODO trim and lowercase etc.

        DataBaseLayer.dataBaseLayer();
        Statement myStatement = DataBaseLayer.myConnection.createStatement();
        ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students,LibraryStock.dbo.borrows,LibraryStock.dbo.books WHERE students.studentId = '" + authorName + "' AND students.studentId = borrows.studentId AND borrows.bookId=books.bookId");


    }
}