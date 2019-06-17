package base;

import java.util.*;
import entity.types.Player;
import object.types.*;

public class Main

public static int gameState;
public static Scanner sc;
public static String[] interactions;
public static String input;
public static void main(String[] args)
{
    public static void main(String[] args)
    {
        //Initializing
        interactions = new String[]{"use", "look", "observe", "move", "open", "close", "take", "inventory", "equip", "wear", "wield", "unequip"};
        input = null;
        sc = new Scanner(System.in);
        gameState = 0;

        //Loading Player
        Player player = new Player("Henry");

        //Loading Game Areas (Game Entities, Game Objects)

        //Henry's House
        Room henryHome = new Room("Henry's House");

        //Blacksmith's
        Room smithy = new Room("Smithy");

        //Town Square
        Room townSquare = new Room("Town Square");

        //Training Square
        Room trainingSquare = new Room("Training Square");

        //Kunesh's House
        Room kunesh = new Room("Kunesh's House");

        //Barn
        Room barn = new Room("Barn");

        //Tavern
        Room tavern = new Room("Tavern");

        //Castle
        Room castle = new Room("Castle");

        //Cleaned House
        Room whiteHouse = new Room("White House");

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
