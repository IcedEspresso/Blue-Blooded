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
        interactions = new String[]{"use", "look", "observe", "move", "open", "close", "take", "inventory", "equip", "wear", "wield", "unequip"};
        input = null;
        sc = new Scanner(System.in);

        //Creating rooms
        Room dev = new Room("dev");
        Room devTwo = new Room("devTwo");
        System.out.println("Rooms created");
        Room[] roomList = new Room[]{dev, devTwo};

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


        GameObject stick = new Weapon("Stick", 2);
        ((StorageObject) chest).addObject(stick);
        GameObject shirt = new Clothing("Shirt", 1, "torso");
        ((StorageObject) chestTwo).addObject(shirt);
        GameObject jeans = new Clothing("jeans", 1, "legs");
        ((StorageObject) chestTwo).addObject(jeans);
        GameObject hat = new Clothing("hat", 1, "head");
        ((StorageObject) chestTwo).addObject(hat);
        GameObject shoes = new Clothing("shoes", 1, "feet");
        ((StorageObject) chestTwo).addObject(shoes);
        //Creating Entities
        GameEntity player = new Player("Player", dev);
        ((Player) player).move(devTwo);
        ((Player) player).move(dev);


        //Gameplay
        //Gamestate <0: Game End
        //Gamestate 0: Normal Mode, such as moving, talking etc.
        //Gamestate 1: Combat Mode
        while(gameState >= 0)
        {
            input = sc.nextLine().toLowerCase();
            if(input.equals("-1"))
            {
                break;
            }

            int object = -1;
            int action = -1;

            for(int i = 0; i < interactions.length; i++)
            {
                if(input.contains(interactions[i]))
                {
                    action = i;
                }
            }

            //Room Based Interaction
            for(int i = 0; i < player.getRoom().getList().size(); i++)
            {
                if(input.contains(player.getRoom().getObject(i).getName().toLowerCase()))
                {
                    object = i;
                }
            }

            if(object == -1 && action < 8 || action == -1 )
            {
                if (action == 2 || action == 1) //Look at room, not object
                {
                    System.out.println(player.getRoom().toString());
                }
                else if(action == 3) //Move to another room
                {
                    boolean movement = false;
                    for(int i = 0; i < roomList.length; i++)
                    {
                        if(input.contains(roomList[i].getName().toLowerCase()))
                        {
                            ((Player) player).move(roomList[i]);
                            movement = true;
                        }
                    }
                    if(!movement)
                    {
                        System.out.println("You cannot move to that location");
                    }
                }
                else if(action == 7) //inventory
                {
                    ((Player)player).viewInventory();
                }
                else
                {
                    System.out.println("That command is invalid");
                }
            }
            else if(action == 0 || action == 4 || action == 5)
            {
                if (action == 0)
                {
                    player.getRoom().getObject(object).use();
                }
                else if(action == 4)
                {
                    player.getRoom().getObject(object).open();
                }
                else if(action == 5)
                {
                    player.getRoom().getObject(object).close();
                }
            }
            else if(action == 1) //look
            {
                player.getRoom().getObject(object).look();
            }

            else if(action == 6) //take
            {
                player.take(player.getRoom().getObject(object));
            }
            else if(action >= 8)
            {
                //Player Inventory Based Interaction
//                for (int i = 0; i < player.getInventory().size(); i++) {
//                    if (input.contains(player.getInventory().get(i).getName().toLowerCase())) {
//                        object = i;
//                        System.out.println(object);
//                        System.out.println(action);
//
//                    }
//                }
                for(int i = 0; i < player.getInventory().size(); i++)
                {
                    if(input.contains(player.getInventory().get(i).getName().toLowerCase()))
                    {
                        object = i;
                    }
                }

                if (action == 8 && object > -1 || action == 9 && object > -1|| action == 10 && object > -1) //equip
                {
                    if(player.getInventory().get(object).getType().equals("weapon"))
                    {
                        player.equip((Weapon) (player.getInventory().get(object)));
                    }
                    else if(player.getInventory().get(object).getType().equals("feet") || player.getInventory().get(object).getType().equals("legs") || player.getInventory().get(object).getType().equals("torso") || player.getInventory().get(object).getType().equals("head"))
                    {
                        player.equip((Clothing) (player.getInventory().get(object)));
                    }
                }
                else if(action == 11 && object > -1) //unequip
                {
                    if(player.getInventory().get(object).getType().equals("weapon"))
                    {
                        player.unequip((Weapon) (player.getInventory().get(object)));
                    }

                    else if(player.getInventory().get(object).getType().equals("feet") || player.getInventory().get(object).getType().equals("legs") || player.getInventory().get(object).getType().equals("torso") || player.getInventory().get(object).getType().equals("head"))
                    {
                        player.unequip((Clothing) (player.getInventory().get(object)));
                    }
                }
                if(object < 0)
                {
                    System.out.println("That command is invalid");
                }
            }
        }
    }
}
