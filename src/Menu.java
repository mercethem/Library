import java.util.Scanner;
public class Menu {
     static void menu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a choose from options downside : ");
        byte options = keyboard.nextByte();
        switch (options){
            case 0: Display.displayOptions();
            case 1: Add.addOptions();
            case 2: Delete.deleteOptions();
            case 3: ChangeOptions.changeAuthorNameSurname();
            case 4: Borrow.borrow();
            case 5: Returning.returning();
            case 6: DataBaseLayer.dataBaseLayer();
            case 7: Display.displayOptions();  //TODO Temporary!!! When finished delete this case
        }
    }
}
