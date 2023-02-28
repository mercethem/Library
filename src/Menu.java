import java.util.Scanner;
public class Menu {
     static void menu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a choose from options downside : ");
        byte options = keyboard.nextByte();
        switch (options){
            case 0: DisplayOptions.displayOptions();
            case 1: Add.addBook();
            case 2: Delete.delete();
            case 3: Borrow.borrow();
            case 4: Returning.returning();
            case 5: DataBaseLayer.dataBaseLayer();
            case 6: Add.addBook();  //TODO Temporary!!! When finished delete this case
        }
    }

}
