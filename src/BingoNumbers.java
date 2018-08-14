
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BingoNumbers
{

    Set<Integer> mybingoNumbers = new HashSet<>();

    public static void main(String[] args)
    {
        System.out.println("Welcome to Bingo!");
        BingoNumbers bingoNumbers = new BingoNumbers();
        BingoNumbers.printMenu();
        bingoNumbers.run();
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

                case "CALL":
                    if (items.length > 1 && items.length <= 75)
                    {

                        int callNumber = Integer.parseInt(items[1]);
                       if (callNumber > 0)
                       {
                           call(callNumber);
                       }
                        mybingoNumbers.add(callNumber);
                        System.out.println(" added " + callNumber);
                    } else
                    {
                        System.err.println("Invalid number selected");
                    }
                    break;

                case "CALLED":
                    for (int number : mybingoNumbers)
                        System.out.println(number);

                    break;
                case "Challenge":
                    if (items.length > 1 && items.length <= 75)
                        mybingoNumbers.remove(items[1]);

                    break;
                case "BINGO!":
                    if (mybingoNumbers.size() >= 4)
                    {
                        System.out.println("Congratulations! You win a fruit cake!");
                        mybingoNumbers.clear();
                    } else

                        System.out.println("Cheater!!");
                    mybingoNumbers.clear();
                    break;

                case "VERIFY":
                    System.out.println("What number are you looking for?");
                    int verifyNumber = Integer.parseInt(items[1]);
                    if (verifyNumber> 0)
                    {
                       verify(verifyNumber);
                    } else
                    {
                        System.out.println("Please enter a number in the range of 1 to 75 when using verify");
                    }
                    break;


                default:
                    System.err.println("Invalid option selected");

            }
        } while (!exit);

    }

    private static void printMenu()
    {
        System.out.println("Enter one of the following commands:");
        System.out.println("Call <1-75>");
        System.out.println("Called");
        System.out.println("Challenge <1-75>");
        System.out.println("Verify <1-75>");
        System.out.println("Bingo!");

    }

    private void call(int number)
    {
        if (mybingoNumbers.contains(number))
        {
            System.out.println("already called!");
        }
    else
        {
         mybingoNumbers.add(number);
        }
    }

    private void verify(int number)
    {
        if (mybingoNumbers.contains(number))
        {
            System.out.println("already called!");

        }
        else
        {
            System.out.println("Not called yet");
        }
    }
}


