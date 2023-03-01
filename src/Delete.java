import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class Delete {
    static void deleteOptions() { //What are you wanting to delete
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to delete with ?\n" +
                "student ?(0)\n" +
                "book ?(1)\n" +
                "author ?(2)\n");
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
        //TODO öğrencinin eğer borrowda kitabı varsa öğrencinin silinemeyeğine dair uyarı yap ve silme
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter student ID for delete student : ");
        long studentId = keyboard.nextLong();
        System.out.println("Are you sure want to delete " + studentId + " that the number is student ?");
        byte question = keyboard.nextByte();
        try {//Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("DELETE FROM LibraryStock.dbo.students WHERE studentId = '" + studentId + "'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void deleteBook() {  //Delete a book
        //TODO öğrencinin eğer borrowda kitabı varsa öğrencinin silinemeyeğine dair uyarı yap ve silme
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter book ID for delete book : ");
        long bookId = keyboard.nextLong();
        System.out.println("Are you sure want to delete " + bookId + " that the number is book ?");
        byte question = keyboard.nextByte();
        try {//Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("DELETE FROM LibraryStock.dbo.books WHERE bookId = '" + bookId + "'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void deleteAuthor() {  //Delete a author
        //TODO öğrencinin eğer borrowda kitabı varsa öğrencinin silinemeyeğine dair uyarı yap ve silme
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter author ID for delete author : ");
        long authorId = keyboard.nextLong();
        System.out.println("Are you sure want to delete " + authorId + " that the number is author ?");
        byte question = keyboard.nextByte();
        try {//Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("DELETE FROM LibraryStock.dbo.authors WHERE authorId = '" + authorId + "'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

}
