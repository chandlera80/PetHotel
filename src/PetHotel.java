
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PetHotel
{
    private Map<Integer, String> rooms = new TreeMap<>();

    public static void main(String[] args)
    {

        PetHotel petHotel = new PetHotel();
        printMenu();
        petHotel.run();
        final int MIN_ROOM_NUMBER = 100;
        final int MAX_ROOM_NUMBER = 120;
    }

    private void run()
    {


        Scanner in = new Scanner(System.in);
        boolean hotelOpen = true;
        do
        {

            System.out.println("Please enter a command");

            String commandLine = in.nextLine();
            String[] words = commandLine.split(" ");
            String command = words[0];
            command = command.toUpperCase();
            int roomNumber;
            int fromRoomNumber;
            int toRoomNumber;
            final int MIN_ROOM_NUMBER = 100;
            final int MAX_ROOM_NUMBER = 120;

            switch (command)
            {

                case "CHECKIN":
                    String petName = words[1];
                    roomNumber = Integer.parseInt(words[2]);
                    checkIn(roomNumber, petName);
                    break;

                case "CHECK OUT":


                    break;
                case "MOVE":
                    fromRoomNumber = Integer.parseInt(words[1]);
                    toRoomNumber = Integer.parseInt(words[2]);
                    move(fromRoomNumber, toRoomNumber);

                    break;
                case "OCCUPANCY":
                    printOccupancy();

                    break;

                case "ROOMS":


                    break;


                default:
                    System.err.println("Invalid option selected");
            }


        } while (hotelOpen);


    }

    private static void printMenu()
    {
        System.out.println("Enter one of the following commands:");
        System.out.println("CheckIn <petname> <room number>");
        System.out.println("CheckOut <roomNumber>");
        System.out.println("Move <fromRoomNumber> to <RoomNumber>");
        System.out.println("Occupancy");
        System.out.println("Rooms");
        System.out.println("CloseForSeason");
        System.out.println("Exit");
    }

    private void checkIn(int roomNumber, String name)
    {
        rooms.put(roomNumber, name);
        System.out.println(name + "checked into room" + roomNumber);
    }

    private void move(int fromRoomNumber, int toRoomNumber)
    {
        boolean fromRoomOccupied = rooms.containsKey(fromRoomNumber);
        boolean toRoomEmpty = !rooms.containsKey(toRoomNumber);
        if (fromRoomOccupied)
        {
            if (toRoomEmpty)
            {
                String petName = rooms.remove(fromRoomNumber);
                rooms.put(toRoomNumber, petName);
                System.out.println("moved " + petName + "from room" + fromRoomNumber + "to room" + toRoomNumber);
            } else
            {
                String petInDestinationRoom = rooms.get(toRoomNumber);
                System.out.println("Sorry, that room is occupied by" + petInDestinationRoom);
            }
        } else
        {
            System.out.println(" Sorry, there is no pet in room" + fromRoomNumber);
        }
    }

    private void printOccupancy()
    {
        for (Map.Entry<Integer, String> entry : rooms.entrySet())
        {
            int roomNumber = entry.getKey();
            String petName = entry.getValue();
            System.out.println(" Room Number: +" + roomNumber + "Pet Name: " + petName);

        }
    }

    private void printRooms()
    {
        final int MIN_ROOM_NUMBER = 100;
        final int MAX_ROOM_NUMBER = 120;
        {
            for (int roomNumber = MIN_ROOM_NUMBER; roomNumber <= MAX_ROOM_NUMBER; roomNumber++)
            {
                System.out.println(roomNumber + " ");
                boolean petInRoom = rooms.containsKey(roomNumber);
                if (petInRoom)
                {
                    String petName = rooms.get(roomNumber);
                    System.out.println(petName);
                }
                else
                {
                    System.out.println("Empty");

                }
                System.out.println();
            }
        }
    }
}