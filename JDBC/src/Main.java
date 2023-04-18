package src;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Boolean exit = false;

        while (!exit) {

            ClearTerminal.clearTerminal();

            System.out.println("-------- Menu --------");
            System.out.println("1. Insert game");
            System.out.println("2. Show table Game");
            System.out.println("3. Delete game");
            System.out.println("4. Exit");
            System.out.println("----------------------");
            
            System.out.print("Enter one option: ");
            int option = sc.nextInt();

            // Vacio el buffer
            sc.nextLine();

            switch (option) {

                case 1:

                    ClearTerminal.clearTerminal();
                    System.out.print("Insert game name: ");
                    String name = sc.nextLine();

                    System.out.print("Insert " + name + " year: ");
                    int year = sc.nextInt();

                    Game game = new Game(name, year);

                    // NextLine para vaciar el Buffer
                    sc.nextLine();
                    DataBase.insertGame(game);
                    Sleep.pause(3000);
                    break;

                case 2:

                    ClearTerminal.clearTerminal();
                    DataBase.showTable();
                    Sleep.pause(5000);
                    break;

                case 3:

                    ClearTerminal.clearTerminal();
                    System.out.print("Insert game name: ");
                    String removeGame = sc.nextLine();

                    DataBase.deleteGame(removeGame);
                    Sleep.pause(3000);
                    break;

                case 4:

                    exit = true;
                    break;
            
                default:
                    System.out.println("Invalid option. Try again...");
                    break;
            }
        }   
        sc.close();
    } 
}
