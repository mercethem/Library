import java.util.Scanner;
public class Menu {
     static void menu() { //Menu options for library system
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter a choose from options downside : \nAdd Options(0)\nChange Options(1)\nDelete Options(2)\nDisplay Options(3)\nBorrow Options(4)\nReturning Options(5)\nDataBase Control(6)\n");
        byte options = keyboard.nextByte();
        switch (options){
            case 0: Add.addOptions();
            case 1: Change.changeOptions();
            case 2: Delete.deleteOptions();
            case 3: Display.displayOptions();
            case 4: Borrow.borrow();
            case 5: Returning.returning();
            case 6: DataBaseLayer.dataBaseLayer();
        }
    }
}
