import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DisplayOptions {
    static void displayOptions() { //Want to view just account or book ?
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What do you want to view ? " +
                "\nView Account ? (0) \nView Book ? (1)");
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
    static void displayAccount() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to view student ID number:");
        long studentId = keyboard.nextLong();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.students WHERE students.studentId = '" + studentId + "'");
            while (myResult.next()) {   //This section have 15 characters before from % for scheme
                System.out.println("ACCOUNT INFORMATION");
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
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class DisplayBook {
    static void displayBookOptions() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What are you want to view with ? \nWith Book Id? (0): \nWith Book Name?(1)"
                + "\nWith Author Name?(2) \n ");
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
        System.out.println("Please enter a Book ID for view to book : ");
        long bookId = keyboard.nextLong();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.books,LibraryStock.dbo.types WHERE books.bookId = '" + bookId + "' AND books.type = types.typeId");
            while (myResult.next()) {
                System.out.printf("Book Id :      %d\nBook Name:     %s\nBook Type:     %s\nAuthor:        %s\nPrint Date:    %s\nPage Count:    %d", myResult.getLong("bookId"), myResult.getString("bookName").trim(),
                        myResult.getString("typeName").trim(), myResult.getString("authorNameSurname").trim(), myResult.getString("printDate"), myResult.getLong("pageCount"));
            }
            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void displayOptionsWithBookName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book name for view to book : ");
        String bookName = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.books,LibraryStock.dbo.types WHERE books.bookName LIKE '%" + bookName + "%' AND books.type = types.typeId");
            while (myResult.next()) {
                System.out.printf("Book Id :      %d\nBook Name:     %s\nBook Type:     %s\nAuthor:        %s\nPrint Date:    %s\nPage Count:    %d", myResult.getLong("bookId"), myResult.getString("bookName").trim(),
                        myResult.getString("typeName").trim(), myResult.getString("authorNameSurname").trim(), myResult.getString("printDate"), myResult.getLong("pageCount"));
            }
            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void displayOptionsWithAuthorname() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a author name for view to book : ");
        String authorName = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("SELECT * FROM LibraryStock.dbo.books,LibraryStock.dbo.types WHERE books.authorNameSurname LIKE '%" + authorName + "%' AND books.type = types.typeId");
            while (myResult.next()) {
                System.out.printf("Book Id :      %d\nBook Name:     %s\nBook Type:     %s\nAuthor:        %s\nPrint Date:    %s\nPage Count:    %d", myResult.getLong("bookId"), myResult.getString("bookName").trim(),
                        myResult.getString("typeName").trim(), myResult.getString("authorNameSurname").trim(), myResult.getString("printDate"), myResult.getLong("pageCount"));
            }
            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}