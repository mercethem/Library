import java.sql.Statement;
import java.util.Scanner;

public class Change {
    public static void changeOptions() { //What are you wanting to change
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is your want to change do to :\n Student ?\nAuthor ?\nBook ?\n");
        short options = keyboard.nextShort();

        short choose;
        if (options == 0) { //What are you wanting to change student information
            System.out.println("What is your want to change to do : \nName and Surname ?(0)\nFaculty ?(1)\nDepartment ?(2)\nBirthdate ?(3)\nGender ?(4)\n");
            choose = keyboard.nextShort();
            switch (choose) { //Take a change
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

            }
        } else if (options == 1) { //What are you wanting to change author information
            System.out.println("What is your want to change to do :\nName and Surname ?(0)\n");
            choose = keyboard.nextShort();
            if (choose == 0) {
                ChangeOptions.changeAuthorNameSurname();
            }
        } else if (options == 2) { //What are you wanting to change book information
            System.out.println("What is your want to change to do :\nName ?(0)\nType ?(1)\nPrint Date ?(2)\nPage Count ?(3)\nBook Author Name Surname ?(4)");
            choose = keyboard.nextShort();
            switch (choose) { //Take a change
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
class ChangeOptions { //Functions for change
    public static void changeStudentNameSurname() { //Change student name and surname
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a Student name and surname for change student name surname : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new name and Surname : ");
        String studentNameSurnameNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  studentNameSurname = '" + studentNameSurnameNew + "' WHERE studentId= '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeStudentFaculty() { //Change student faculty
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a faculty for change student faculty : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new faculty : ");
        String studentFacultyNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  faculty = '" + studentFacultyNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeStudentDepartment() { //Change student department
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a department for change the student department : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new department : ");
        String studentDepartmentNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  department = '" + studentDepartmentNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeStudentBirthDate() { //Change student birthdate
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a birth date for change student birth date : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new birth date : ");
        String studentBirthDateNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  birthDate = '" + studentBirthDateNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeStudentGender() { //Change student gender
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a gender for change student gender : ");
        long studentId = keyboard.nextLong();
        System.out.println("Please enter new gender : ");
        String studentGenderNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.students SET  gender = '" + studentGenderNew + "' WHERE studentId = '%" + studentId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeAuthorNameSurname() { //Change author name and surname
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a author Id for change the author name surname : ");
        long authorId = keyboard.nextLong();
        System.out.println("Please enter new name and Surname : ");
        String authorNameSurnameNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.authors SET  authorNameSurname = '" + authorNameSurnameNew + "' WHERE authorId= '%" + authorId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeBookName() { //Change name of book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book ID for change book name : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new book name : ");
        String bookNameNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET  bookName = '" + bookNameNew + "' WHERE bookId= '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeBookType() { //Change type of book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book ID for change the book type : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new book type : ");
        String bookTypeNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET  [type] = '" + bookTypeNew + "' WHERE bookId= '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeBookPrintDate() { //Change print date of book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book ID for change the book print date : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new print date : ");
        String bookPrintDate = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET  [pageCount] = '" + bookPrintDate + "' WHERE bookId= '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeBookPageCount() { //Change book count of book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a book ID for change the book page count : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new page count : ");
        String newPageCount = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET pageCount = '" + newPageCount + "' WHERE bookId = '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }

    public static void changeBookAuthorNameSurname() { //Change name and surname of author of book
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a bookId for change the author name and surname of book : ");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter new author name and Surname : ");
        String bookAuthorNameSurnameNew = keyboard.nextLine();
        try { //Database layer function and SQL query
            DataBaseLayer.dataBaseLayer();
            Statement myStatement = DataBaseLayer.myConnection.createStatement();
            myStatement.executeQuery("UPDATE LibraryStock.dbo.books SET  authorNameSurname = '" + bookAuthorNameSurnameNew + "' WHERE bookId = '%" + bookId + "%'");
            myStatement.close(); // close statement
            DataBaseLayer.myConnection.close(); // close connection
            Menu.menu();
        } catch (Exception e) {
            System.out.println();
            Menu.menu();
        }
    }
}
