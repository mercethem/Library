import java.util.Scanner;

public class Delete {
    static void delete(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter want to delete book's id");
        long bookId = keyboard.nextLong();
        System.out.println("Please enter want to delete book's name : ");
        String bookName = keyboard.nextLine();
        System.out.println("Please enter want to delete book's author : ");
        String bookAuthor = keyboard.nextLine();

    }
}
