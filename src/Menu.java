import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    static void menu() throws SQLException, ClassNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter choose a option from downside : ");
        byte options = keyboard.nextByte();
        switch (options){
            case 0: DisplayOptions.displayOptions();
            case 1: Add.add();
            case 2: Delete.delete();
            case 3: Borrow.borrow();
            case 4: Returning.returning();
            case 5: DataBaseLayer.dataBaseLayer();

        }
    }

}
