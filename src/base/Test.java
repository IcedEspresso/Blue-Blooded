package base;

import entity.types.Player;
import object.types.*;

import java.util.*;

public class Test
{
    public static int gameState = 0;
    public static Scanner sc;
    public static String[] interactions;
    public static String input;
    public static void main(String[] args)
    {

                                        //Loading Game Assets
        //Initializing Values
        interactions = new String[]{"use"};
        input = null;
        sc = new Scanner(System.in);

        //Creating rooms
        Room dev = new Room("dev");
        Room devTwo = new Room("devTwo");
        System.out.println("Room created");

        //Creating objects
        GameObject chest = new StorageObject("Chest", true);
        System.out.println("Cnest created");
        GameObject lockedChest = new StorageObject("Locked Chest", false);
        System.out.println("Locked Chest created");
        dev.addObject(chest);
        System.out.println("Chest added");
        dev.addObject(lockedChest);
        System.out.println("Locked Chest added");
        System.out.println(dev);

        GameObject chestTwo = new StorageObject("Chest", true);
        System.out.println("Cnest created");
        GameObject lockedChestTwo = new StorageObject("Locked Chest", false);
        System.out.println("Locked Chest created");
        devTwo.addObject(chestTwo);
        System.out.println("Chest added");
        devTwo.addObject(lockedChestTwo);
        System.out.println("Locked Chest added");
        System.out.println(dev);

        //Creating Entities
        GameEntity player = new Player("Tim", dev);
        ((Player) player).move(devTwo);
        ((Player) player).move(dev);

        while(gameState >= 0)
        {
            input = sc.nextLine();

            int object = -1;
            int action = -1;

            for(int i = 0; i < interactions.length; i++)
            {
                if(input.contains(interactions[i]))
                {
                    action = i;
                }
            }

            for(int i = 0; i < dev.getList().size(); i++)
            {
                if(input.contains(dev.getObject(i).getName()))
                {
                    object = i;
                }
            }

            if(object == -1 || action == -1)
            {
                System.out.println("That command is invalid");
            }
            else if(action == 0)
            {
                dev.getObject(object).use();
            }
        }

//        public static void interactor(String input)
//        {
//
//        }
    }


}
