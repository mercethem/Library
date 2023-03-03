import java.sql.Statement;
import java.util.Scanner;

public class Add {
    static void addOptions() { //Add options for what do you want to add new student,new book or new author
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to add ?\n student ?(0)\n book ?(1)\n author ?(2)\n");
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

            DataBaseLayer.dataBaseLayer(); //Database layer function and SQL query
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery
                    ("INSERT INTO LibraryStock.dbo.students  (studentId,studentNameSurname,birthDate,faculty,department,gender ) " +
                            "VALUES ('" + studentId + "','" + studentNameSurname + "', '" + birthDate + "','" + faculty + "','" + department + "','" + gender + "')");

            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();

        } catch (Exception e) {
            System.out.println();
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

            System.out.println("Please enter want to add book's page count : ");
            int pageCount = keyboard.nextInt();
            keyboard.nextLine();

            System.out.println("Please enter want to add book's type : ");
            String type = keyboard.nextLine();

            System.out.println("Please enter want to add book's amount : ");
            int amount = keyboard.nextInt();


            DataBaseLayer.dataBaseLayer(); //Database layer function and SQL query
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery
                    ("INSERT INTO LibraryStock.dbo.authors  (authorNameSurname)" +
                            "VALUES ('"+authorNameSurname+"') INSERT INTO LibraryStock.dbo.books  ( bookName, [type],printDate, [pageCount], authorNameSurname,amount,authorId)" +
                            "VALUES ( '"+bookName+"','"+type+"','"+printDate+"','"+pageCount+"','"+printDate+"','"+amount+"'," +
                            "(SELECT authorId FROM LibraryStock.dbo.authors WHERE authors.authorNameSurname= '"+authorNameSurname+"'))");

            System.out.println();
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    static void addAuthor() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to add author's name and surname : ");
        String authorNameSurname = keyboard.nextLine();

        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery
                    ("INSERT INTO LibraryStock.dbo.authors  ( authorNameSurname)" +
                            "VALUES ('" + authorNameSurname + "')");
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
