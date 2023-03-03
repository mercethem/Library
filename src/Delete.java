import java.sql.Statement;
import java.util.Scanner;

class Delete {
    static void deleteOptions() { //What are you wanting to delete
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to delete with ?\nstudent ?(0)\nbook ?(1)\nauthor ?(2)\n");
        byte option = keyboard.nextByte();
        switch (option) {
            case 0:
                DeleteOptions.deleteStudent();
            case 1:
                DeleteOptions.deleteBook();
            case 2:
                DeleteOptions.deleteAuthor();

        }
    }
}

class DeleteOptions {
    public static void deleteStudent() { //Delete a student
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter student ID for delete student : ");
        long studentId = keyboard.nextLong();
        System.out.println("Are you sure want to delete " + studentId + " that the number is student ?\n NO = ANY CASE YES = 1");
        byte question = keyboard.nextByte();
        if (question == 1) {
            try {//Database layer function and SQL query
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("DELETE FROM LibraryStock.dbo.students WHERE studentId = '" + studentId + "'");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
                Menu.menu();
            } catch (Exception e) {
                System.out.println();
                Menu.menu();
            }
        }
        else {
            Menu.menu();
        }
    }

    public static void deleteBook() {  //Delete a book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter book ID for delete book : ");
        long bookId = keyboard.nextLong();
        System.out.println("Are you sure want to delete " + bookId + " that the number is book ?\n NO = ANY CASE YES = 1");
        byte question = keyboard.nextByte();
        if (question == 1) {
            try {//Database layer function and SQL query
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("DELETE FROM LibraryStock.dbo.books WHERE bookId = '" + bookId + "'");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
                Menu.menu();
            } catch (Exception e) {
                System.out.println();
                Menu.menu();
            }
        }
        else {
            Menu.menu();
        }
    }

    public static void deleteAuthor() {  //Delete an author
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter author ID for delete author : ");
        long authorId = keyboard.nextLong();
        System.out.println("Are you sure want to delete " + authorId + " that the number is student ?\n NO = ANY CASE YES = 1");
        byte question = keyboard.nextByte();
        if (question == 1) {
            try {//Database layer function and SQL query
                DataBaseLayer.dataBaseLayer();
                Statement myStatement = DataBaseLayer.myConnection.createStatement();
                myStatement.executeQuery("DELETE FROM LibraryStock.dbo.authors WHERE authorId = '" + authorId + "'");
                myStatement.close(); // close statement
                DataBaseLayer.myConnection.close(); // close connection
                Menu.menu();
            } catch (Exception e) {
                System.out.println();
                Menu.menu();
            }
        }
        else {
            Menu.menu();
        }
    }

}
