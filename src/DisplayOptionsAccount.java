import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class Display {
    static void displayOptions() { //Want to view just account or book ?
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What do you want to view ?\nView Account ? (0) \nView Book ? (1)");
        byte options = keyboard.nextByte();
        switch (options) {
            case 0:
                DisplayOptionsAccount.displayAccount();
            case 1:
                DisplayOptionsBook.displayWithBook();
        }
    }
}

public class DisplayOptionsAccount {
    static void displayAccount() { //View student information and if there is some borrow books
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to view student ID number:");
        long studentId = keyboard.nextLong();
        try { //Database layer function and SQL query about student information
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
            while (myResult.next()) {   //This section have 15 characters before from % for scheme
                System.out.println("ACCOUNT INFORMATION");
                System.out.print("--------------------");
                System.out.printf("\nStudent ID:    %d\nName Surname:  %S\nFaculty:       %S\nDepartment:    %S\nBirthdate:     %S\nGender:        %S\n",
                        myResult.getLong("studentId"), myResult.getString("studentNameSurname").trim(),
                        myResult.getString("faculty").trim(), myResult.getString("department").trim(),
                        myResult.getString("birthDate").trim().substring(0, 2) + "/" + myResult.getString("birthDate").substring(3, 5) + "/" + myResult.getString("birthDate").substring(6, 10),
                        myResult.getString("gender").trim() + "\n");
            } //Database layer function and SQL query about borrow books
            Statement myStatement2 = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult2 = myStatement2.executeQuery("SELECT * FROM LibraryStock.dbo.students,LibraryStock.dbo.borrows,LibraryStock.dbo.books WHERE students.studentId = '" + studentId + "' AND students.studentId = borrows.studentId AND borrows.bookId=books.bookId");
            System.out.println("BORROWED BOOKS");
            System.out.println("--------------");
            while (myResult2.next()) {   //This section have 15 characters before from % for scheme
                System.out.printf("Borrowed Book: %s / Type : %s => Author: %s ((Taken Date: %s Brought Date: %s\n", myResult2.getString("bookName").trim(), myResult2.getString("type").trim(), myResult2.getString("authorNameSurname").trim(),
                        myResult2.getString("takenDate").trim().substring(0, 2) + "/" + myResult2.getString("takenDate").substring(3, 5) + "/" + myResult2.getString("takenDate").substring(6, 10) + "))",
                        myResult2.getString("broughtDate").trim().substring(0, 2) + "/" + myResult2.getString("broughtDate").substring(3, 5) + "/" + myResult2.getString("broughtDate").substring(6, 10)+ "))");
            }
            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }
}
    class DisplayOptionsBook {

    static void displayWithBook() { //View book information options with id, name of book or name of author
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What are you want to view with ? \nWith Book Id? (0): \nWith Book Name?(1)\nWith Author Name?(2)\n");
        byte options = keyboard.nextByte();
        switch (options) {
            case 0:
                displayWithBookId();
            case 1:
                displayWithBookName();
            case 2:
                displayWithAuthorname();
        }
    }

    static void displayWithBookId() { //View book information options with id of book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a Book ID for view to book : ");
        long bookId = keyboard.nextLong();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.books WHERE books.bookId = '" + bookId + "'");
            while (myResult.next()) {
                System.out.printf("Book Id :      %d\nBook Name:     %s\nBook Type:     %s\nAuthor:        %s\nPrint Date:    %s\nPage Count:    %d", myResult.getLong("bookId"), myResult.getString("bookName").trim(),
                        myResult.getString("type").trim(), myResult.getString("authorNameSurname").trim(), myResult.getString("printDate"), myResult.getLong("pageCount"));
            }
            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    static void displayWithBookName() { //View book information options with name of book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book name for view to book : ");
        String bookName = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.books WHERE books.bookName LIKE '%" + bookName + "%'");
            while (myResult.next()) {
                System.out.printf("Book Id :      %d\nBook Name:     %s\nBook Type:     %s\nAuthor:        %s\nPrint Date:    %s\nPage Count:    %d", myResult.getLong("bookId"), myResult.getString("bookName").trim(),
                        myResult.getString("type").trim(), myResult.getString("authorNameSurname").trim(), myResult.getString("printDate"), myResult.getLong("pageCount"));
            }
            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    static void displayWithAuthorname() { //View book information options with name of author of book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a author name for view to book : ");
        String authorName = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.books WHERE books.authorNameSurname LIKE '%" + authorName + "%'");
            while (myResult.next()) {
                System.out.printf("Book Id :      %d\nBook Name:     %s\nBook Type:     %s\nAuthor:        %s\nPrint Date:    %s\nPage Count:    %d", myResult.getLong("bookId"), myResult.getString("bookName").trim(),
                        myResult.getString("type").trim(), myResult.getString("authorNameSurname").trim(), myResult.getString("printDate"), myResult.getLong("pageCount"));
            }
            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }
}