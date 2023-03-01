import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Add {
    static void addOptions() { //Add options for what do you want to add new student,new book or new author
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to add ?\n" +
                "student ?(0)\n" +
                "book ?(1)\n" +
                "author ?(2)\n");
        byte option = keyboard.nextByte();
        switch (option) {
            case 0:
                AddOptions.addStudent();
            case 1:
                AddOptions.addBook();
            case 2:
                AddOptions.addAuthor();

        }
    }
}

class AddOptions {
    static void addStudent() { //Adding information for new student
        Scanner keyboard = new Scanner(System.in);
        try {
            System.out.println("Please enter want to add student's ID : ");
            long studentId = keyboard.nextLong();
            keyboard.nextLine();

            System.out.println("Please enter want to add student's name and surname : ");
            String studentNameSurname = keyboard.nextLine();

            System.out.println("Please enter want to add student's birth date : ");
            String birthDate = keyboard.nextLine();

            System.out.println("Please enter want to add student's gender : ");
            String gender = keyboard.nextLine();

            System.out.println("Please enter want to add student's faculty : ");
            String faculty = keyboard.nextLine();

            System.out.println("Please enter want to add student's department : ");
            String department = keyboard.nextLine();

            System.out.println("Please enter want to add student's grade : ");
            String grade = keyboard.nextLine();

            DataBaseLayer.dataBaseLayer(); //Database layer function and SQL query
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery
                    ("INSERT INTO LibraryStock.dbo.students  (studentId,studentNameSurname,birthDate,faculty,department,gender,grade ) " +
                            "VALUES ('" + studentId + "','" + studentNameSurname + "', '" + birthDate + "','" + faculty + "','" + department + "','" + gender + "','" + grade + "')");

            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();

        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    static void addBook() { //Adding information for new book
        Scanner keyboard = new Scanner(System.in);
        try {

            System.out.println("Please enter want to add book's name : ");
            String bookName = keyboard.nextLine();

            System.out.println("Please enter want to add author's name and surname : ");
            String authorNameSurname = keyboard.nextLine();

            System.out.println("Please enter want to add book's print date : ");
            String printDate = keyboard.nextLine();

            System.out.println("Please enter want to add book's author ID : ");
            long authorId = keyboard.nextLong();

            System.out.println("Please enter want to add book's ID number : ");
            long bookId = keyboard.nextLong();

            System.out.println("Please enter want to add book's page count : ");
            int pageCount = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Please enter want to add book's type : ");
            String type = keyboard.nextLine();


            DataBaseLayer.dataBaseLayer(); //Database layer function and SQL query
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery
                    ("INSERT INTO LibraryStock.dbo.authors  (authorId, authorNameSurname)" +
                            "VALUES ('" + authorId + "', '" + authorNameSurname + "')" + "INSERT INTO LibraryStock.dbo.books  (bookId, bookName, type,printDate,authorId, [pageCount], authorNameSurname) " +
                            "VALUES ('" + bookId + "', '" + bookName + "','" + type + "','" + printDate + "','" + authorId + "','" + pageCount + "','" + authorNameSurname + "')");

            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    static void addAuthor() { //Adding information for new author
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to add author's name and surname : ");
        String authorNameSurname = keyboard.nextLine();

        System.out.println("Please enter want to add book's author ID : ");
        String authorId = keyboard.next();

        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery
                    ("INSERT INTO LibraryStock.dbo.authors  (authorId, authorNameSurname)" +
                            "VALUES ('" + authorId + "', '" + authorNameSurname + "')");
            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }
}
