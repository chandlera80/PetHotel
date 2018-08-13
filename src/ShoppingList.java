


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ShoppingList

{
    private ArrayList<String> ShoppingList = new ArrayList<>();

    public static void main(String[] args)
    {
        System.out.println("Welcome to my shopping list!");
        ShoppingList myShoppingList = new ShoppingList();
        myShoppingList.printMenu();
        myShoppingList.run();

    }

    private void run()
    {
        Scanner in = new Scanner(System.in);

        boolean exit = false;
        do
        {

            System.out.println("Please enter a command");


            String commandLine = in.nextLine();
            String[] items = commandLine.split(" ");

            String command = items[0];
            command = command.toUpperCase();
            System.out.println("The command is " + command);

            switch (command)
            {

                case "ADD":
                    if (items.length == 2)
                    {
                        ShoppingList.add(items[1]);
                    } else
                    {
                        System.out.println(" Illegal add command. GO DIRECTLY TO JAIL!!");
                    }
                    break;
                case "PRINT":
                    int i;
                    for (i = 1; i < ShoppingList.size(); i++)
                        System.out.println(" index: " + (i) + "item name:" + ShoppingList.get(i));

                    break;
                case "REMOVE":
                    ShoppingList.remove(items[1]);

                    break;
                case "CLEAR":
                    ShoppingList.clear();
                    break;

                case "SORT":
                    Collections.sort(ShoppingList);
                    for (String aShoppingList : ShoppingList)
                        System.out.println("Shopping list sorted: " + aShoppingList);
                    break;

                case "FIND":
                    System.out.println("What can I find for you today?");
                    String FindLine = in.nextLine();
                    if (ShoppingList.contains(FindLine))
                    {
                        System.out.println("Found it!");
                    } else
                    {
                        System.out.println("No such item!");
                    }
                    break;

                case "EXIT":
                    System.out.println("Bye Felicia!");
                    exit = true;
                    break;

                default:
                    System.err.println("Invalid option selected");

            }
        } while (!exit);

    }

    private void printMenu()
    {
        System.out.println("Enter one of the following commands:");
        System.out.println("Add <item name>");
        System.out.println("Print");
        System.out.println("Remove <index>");
        System.out.println("Clear");
        System.out.println("Sort");
        System.out.println("Find");
        System.out.println("Exit");
    }
}

