import java.util.Scanner;

public class Add {
    static void add(){

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to add book's ID number : ");
        Long bookID = keyboard.nextLong();
        System.out.println("Please enter want to add book's name : ");
        String bookName = keyboard.nextLine();
        keyboard.next();
        System.out.println("Please enter want to add author name : ");
        String authorName = keyboard.nextLine();
        System.out.println("Please enter want to add book's printdate : ");
        String printDate = keyboard.nextLine();
        System.out.println("Please enter want to add book's page count : ");
        int pageCount = keyboard.nextInt();
        System.out.println("Please enter want to add book's type : ");
        String bookType = keyboard.nextLine();

    }
}
