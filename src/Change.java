import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Change {
    public static void changeOptions() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your want to change do to :\n" +
                "Student ?\nAuthor ?\nBook ?\n");
        short options = keyboard.nextShort();

        short choose;
        if (options == 0) {
            System.out.println("What is your want to change to do :\n" +
                    "Name and Surname ?(0)\n" +
                    "Faculty ?(1)\n" +
                    "Department ?(2)\n" +
                    "Birthdate ?(3)\n" +
                    "Gender ?(4)\n" +
                    "Grader ?(5)\n");
            choose = keyboard.nextShort();
            switch (choose) {
                case 0:
                    ChangeOptions.changeStudentNameSurname();
                case 1:
                    ChangeOptions.changeStudentFaculty();
                case 2:
                    ChangeOptions.changeStudentDepartment();
                case 3:
                    ChangeOptions.changeStudentBirthDate();
                case 4:
                    ChangeOptions.changeStudentGender();
                case 5:
                    ChangeOptions.changeStudentGrade();
            }
        } else if (options == 1) {
            System.out.println("What is your want to change to do :\n" +
                    "Name and Surname ?(0)\n");
            choose = keyboard.nextShort();
            switch (choose) {
                case 0:
                    ChangeOptions.changeAuthorNameSurname();
            }
        } else if (options == 2) {
            System.out.println("What is your want to change to do :\n" +
                    "Name ?(0)\n" +
                    "Type ?(1)\n" +
                    "Print Date ?(2)\n" +
                    "Page Count ?(3)\n" +
                    "Book Author Name Surname ?(4)");
            choose = keyboard.nextShort();
            switch (choose) {
                case 0:
                    ChangeOptions.changeBookName();
                case 1:
                    ChangeOptions.changeBookType();
                case 2:
                    ChangeOptions.changeBookPrintDate();
                case 3:
                    ChangeOptions.changeBookPageCount();
                case 4:
                    ChangeOptions.changeBookAuthorNameSurname();
            }
        }
    }

}
class ChangeOptions {
    public static void changeStudentNameSurname() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a Student name and surname for change student name surname : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new name and Surname : ");
        String studentNameSurnameNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  studentNameSurname = '" + studentNameSurnameNew + "' WHERE studentId= '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeStudentFaculty() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a faculty for change student faculty : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new faculty : ");
        String studentFacultyNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  faculty = '" + studentFacultyNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeStudentDepartment() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a department for change the student department : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new department : ");
        String studentDepartmentNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  department = '" + studentDepartmentNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeStudentBirthDate() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a birth date for change student birth date : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new birth date : ");
        String studentBirthDateNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  birthDate = '" + studentBirthDateNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeStudentGender() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a gender for change student gender : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new gender : ");
        String studentGenderNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  gender = '" + studentGenderNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeStudentGrade() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a grade for change the student grade: ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new grade : ");
        String studentGradeNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  grade = '" + studentGradeNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeAuthorNameSurname() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a author Id for change the author name surname : ");
        long authorId = keyboard.nextLong();
        System.out.println("Please enter new name and Surname : ");
        String authorNameSurnameNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.authors SET  authorNameSurname = '" + authorNameSurnameNew + "' WHERE authorId= '%" + authorId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeBookName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book ID for change book name : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new book name : ");
        String bookNameNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET  bookName = '" + bookNameNew + "' WHERE bookId= '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeBookType() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book ID for change the book type : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new book type : ");
        String bookTypeNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET  [type] = '" + bookTypeNew + "' WHERE bookId= '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeBookPrintDate() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book ID for change the book print date : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new print date : ");
        String bookPrintDate = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET  [pageCount] = '" + bookPrintDate + "' WHERE bookId= '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeBookPageCount() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book ID for change the book page count : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new page count : ");
        String newPageCount = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET pageCount = '" + newPageCount + "' WHERE bookId = '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }

    public static void changeBookAuthorNameSurname() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a bookId for change the author name and surname of book : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new author name and Surname : ");
        String bookAuthorNameSurnameNew = keyboard.nextLine();
        try {
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            ResultSet myResult = myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET  authorNameSurname = '" + bookAuthorNameSurnameNew + "' WHERE bookId = '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println(e);
            Menu.menu();
        }
    }
}
