package base;

import java.util.*;
import entity.types.*;
import object.types.*;

public class Main
{
    public static int gameState;
    public static Scanner sc;
    public static String[] interactions;
    public static String input;

    public static void main(String[] args)
    {
        //Initializing

        System.out.println("Loading...");
        interactions = new String[]{"use", "look", "observe", "move", "open", "close", "take", "inventory", "equip", "wear", "wield", "unequip", "attack", "stats", "talk"};
        /**Interactions
         * 0 = use
         * 1 = look
         * 2 = observe
         * 3 = move
         * 4 = open
         * 5 = close
         * 6 = take
         * 7 = inventory
         * 8 = equip
         * 9 = wear
         * 10 = wield
         * 11 = unequip
         * 12 = attack
         * 13 = stats
         * 14 = talk
         */

        input = null;
        sc = new Scanner(System.in);
        gameState = 0;

        //Loading Game Areas (Game Entities, Game Objects)

        System.out.println("Loading rooms...");
        //Henry's House
        Room henryHome = new Room("Henry's House");

        GameEntity mom = new Nonplayer("Henry's Mom", henryHome, "invulnerable");
        henryHome.addEntity(mom);

            //Create objects
        GameObject chest = new StorageObject("Henry's Chest", true);
        GameObject feltHat = new Clothing("Felt Hat", 1, "head");
        GameObject greenShirt = new Clothing("Green Shirt", 1, "torso");
        GameObject redHose = new Clothing("Red Hose", 1, "legs");
        GameObject brownShoes = new Clothing("Brown Shoes", 1, "feet");

        ((StorageObject) chest).addObject(feltHat);
        ((StorageObject) chest).addObject(greenShirt);
        ((StorageObject) chest).addObject(redHose);
        ((StorageObject) chest).addObject(brownShoes);

        henryHome.addObject(chest);

        //Blacksmith's
        Room smithy = new Room("Smithy");

        //Town Square
        Room townSquare = new Room("Town Square");

        GameEntity shadyMan = new Nonplayer("Shady Man", townSquare, "passive");
        GameObject woodenSword = new Weapon("Wooden Sword", 3);
        townSquare.addObject(woodenSword);
        shadyMan.take(woodenSword);
        townSquare.addEntity(shadyMan);

        GameEntity coalMerchant = new Nonplayer("Coal Merchant", townSquare, "invulnerable");
        GameObject coal = new MiscObject("Coal", false);

        townSquare.addEntity(coalMerchant);
        townSquare.addObject(coal);


        //Training Square
        Room trainingSquare = new Room("Training Square");

        GameObject leatherBoots = new Clothing("Leather Boots", 2, "feet");

        trainingSquare.addObject(woodenSword);
        trainingSquare.addObject(leatherBoots);

        //Kunesh's House
        Room kuneshHome = new Room("Kunesh's House");
        GameEntity kunesh = new Nonplayer("Kunesh", kuneshHome, "passive");
        GameObject hammer = new Weapon("Dad's Hammer", 3);

        kuneshHome.addEntity(kunesh);
        kuneshHome.addObject(hammer);
        kunesh.take(hammer);
        kunesh.equip((Weapon) hammer);
        kuneshHome.addObject(hammer);
        kunesh.setHealth(15);

        //Tavern
        Room tavern = new Room("Tavern");

        //Castle
        Room castle = new Room("Castle");

        //Cleaned House
        Room whiteHouse = new Room("White House");

        //Loading Player
        System.out.println("Loading entities");
        GameEntity player = new Player("Player", henryHome);

        Room[] roomList = new Room[]{henryHome, smithy, townSquare, trainingSquare, kuneshHome, tavern, castle, whiteHouse};

        introSequence();

        //Quest States
        int dad = 0; //3 States, Hammer taken, coal bought, crossguard taken
        int dadHammer = 0; //1 State, Hammer Taken
        int beatKunesh = 0; //1 State, Kunesh Beaten
        int shadyManLine = 0; // 4 states, town square, training square, training square equip, combat
        int attacksLeft = 3; //part of shady man line

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

            /**Interactions
             * 0 = use
             * 1 = look
             * 2 = observe
             * 3 = move
             * 4 = open
             * 5 = close
             * 6 = take
             * 7 = inventory
             * 8 = equip
             * 9 = wear
             * 10 = wield
             * 11 = unequip
             * 12 = attack
             * 13 = stats
             * 14 = talk
             */

            /**
             * Game States
             * -1 = End Loop
             * 0 = Neutral
             * 1 = Kunesh Sequence
             * 2 = White House sequence
             * 3 = Training Square sequence
             */

            if(gameState == 0)
            {

                if(action == 0)
                {
                    //Check for object in question (use what?)
                    for(int i = 0; i < player.getRoom().getList().size(); i++)
                    {
                        if(input.contains(player.getRoom().getObject(i).getName().toLowerCase()))
                        {
                            object = i;
                        }
                    }

                    if(object < 0)
                    {
                        System.out.println("I understand that you want to use something?");
                    }
                    else
                    {
                        player.getRoom().getObject(object).use();
                    }
                }

                if(action == 1 || action == 2) // Looking or Observing
                {
                    //Check for object to observe or look at
                    for(int i = 0; i < player.getRoom().getList().size(); i++)
                    {
                        if(input.contains(player.getRoom().getObject(i).getName().toLowerCase()))
                        {
                            object = i;
                        }
                    }

                    if(object < 0)
                    {
                        System.out.println(player.getRoom().toString());
                    }
                    else
                    {
                        player.getRoom().getObject(object).look();
                    }
                }

                if(action == 3) // Move
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

                if(action == 4)
                {
                    //Check for object in question (use what?)
                    for(int i = 0; i < player.getRoom().getList().size(); i++)
                    {
                        if(input.contains(player.getRoom().getObject(i).getName().toLowerCase()))
                        {
                            object = i;
                        }
                    }

                    if(object < 0)
                    {
                        System.out.println("I understand that you want to use something?");
                    }
                    else
                    {
                        player.getRoom().getObject(object).open();
                    }
                }

                if(action == 5)
                {
                    //Check for object in question (use what?)
                    for(int i = 0; i < player.getRoom().getList().size(); i++)
                    {
                        if(input.contains(player.getRoom().getObject(i).getName().toLowerCase()))
                        {
                            object = i;
                        }
                    }

                    if(object < 0)
                    {
                        System.out.println("I understand that you want to use something?");
                    }
                    else
                    {
                        player.getRoom().getObject(object).close();
                    }
                }

                if(action == 6) // Take specified object
                {
                    //Take specificed object (take what?)
                    for (int i = 0; i < player.getRoom().getList().size(); i++)
                    {
                        if (input.contains(player.getRoom().getObject(i).getName().toLowerCase()))
                        {
                            object = i;
                        }
                    }

                    if (object < 0)
                    {
                        System.out.println("I understand you're trying to take something?");
                    }
                    else if(player.getRoom().getObject(object).getName().equals("Dad's hammer") && dadHammer == 0)
                    {
                        if(beatKunesh == 0)
                        {
                            //Initiate Kunesh sequence
                            System.out.println("Kunesh approaches you, apparently drunk. \n\"Thas me hammer you fool, you ain't takin' it!\"\n");
                            System.out.println("You're now in combat! Kunesh picks up the hammer and prepares to attack");

                            gameState = 1;
                        }
                        else
                        {
                            player.take(player.getRoom().getObject(object));
                            dadHammer = 1;
                        }
                    }
                    else {
                        player.take(player.getRoom().getObject(object));
                    }
                }

                if(action == 7) //inventory
                {
                    ((Player)player).viewInventory();
                }

                if (action == 8 || action == 9 || action == 10) //equip
                {
                    //Checks for object in question INSIDE THE PLAYER'S INVENTORY
                    for(int i = 0; i < player.getInventory().size(); i++)
                    {
                        if(input.contains(player.getInventory().get(i).getName().toLowerCase()))
                        {
                            object = i;
                        }
                    }

                    if(object < 0)
                    {
                        System.out.println("Sorry, I understand that you're trying to equip something?");
                    }
                    else if(player.getInventory().get(object).getType().equals("weapon"))
                    {
                        player.equip((Weapon) (player.getInventory().get(object)));
                    }
                    else if(player.getInventory().get(object).getType().equals("feet") || player.getInventory().get(object).getType().equals("legs") || player.getInventory().get(object).getType().equals("torso") || player.getInventory().get(object).getType().equals("head"))
                    {
                        player.equip((Clothing) (player.getInventory().get(object)));
                    }
                }

                if(action == 11) //unequip
                {
                    //Checks for object in question INSIDE THE PLAYER'S INVENTORY
                    for(int i = 0; i < player.getInventory().size(); i++)
                    {
                        if(input.contains(player.getInventory().get(i).getName().toLowerCase()))
                        {
                            object = i;
                        }
                    }

                    if(object < 0)
                    {
                        System.out.println("Sorry, I understand you're trying to unequip something?");
                    }
                    else if(player.getInventory().get(object).getType().equals("weapon"))
                    {
                        player.unequip((Weapon) (player.getInventory().get(object)));
                    }

                    else if(player.getInventory().get(object).getType().equals("feet") || player.getInventory().get(object).getType().equals("legs") || player.getInventory().get(object).getType().equals("torso") || player.getInventory().get(object).getType().equals("head"))
                    {
                        player.unequip((Clothing) (player.getInventory().get(object)));
                    }
                }

                if(action == 13)
                {
                    System.out.println("Your health is " + player.getHealth());
                    System.out.println("Your defense is " + player.getDefense());
                    System.out.println("Your attack is " + player.getAttack());
                }

                if(action == 14)
                {
                    //Identify the entity the player wants to talk to
                    for(int i = 0; i < player.getRoom().getPeople().size(); i++)
                    {
                        if(input.contains(player.getRoom().getPeople().get(i).getName().toLowerCase()))
                        {
                            object = i;
                        }
                    }

                    if(object < 0)
                    {
                        System.out.println("I understand you want to talk to someone?");
                    }
                    else if(player.getRoom().getPeople().get(object) == mom)
                    {
                        introSequence();
                    }
                    else if(player.getRoom().getPeople().get(object) == shadyMan)
                    {
                        if(shadyManLine == 0)
                        {
                            shadyManSquare();
                            while (true) {
                                String tempInput = sc.nextLine();
                                if (tempInput.toLowerCase().equals("yes")) {
                                    townSquare.removeEntity(shadyMan);
                                    trainingSquare.addEntity(shadyMan);

                                    System.out.println("See you at the Training Square then, Henry!");
                                    shadyManLine++;
                                    break;
                                } else if (tempInput.toLowerCase().equals("no")) {
                                    System.out.println("No problem Henry, talk to me later if you're still interested!");
                                    break;
                                } else {
                                    System.out.println("Invalid Response, please print \"Yes\" or \"No\"");
                                }
                            }
                        }
                        else if(shadyManLine == 1)
                        {
                            System.out.println("\"Welcome Henry! Go pick up that sword and put on those boots, talk again to me when you're ready.\"");
                            shadyManLine = 2;
                        }
                        else if(shadyManLine == 2)
                        {
                            System.out.println("You're now in combat with the Shady Man!");
                            System.out.println("\"Get ready Henry, I'm going to teach you how to attack for real this time! No more drills.\"");

                            System.out.println("\"Alright Henry, all you have to do is hit me\"\n\"All you have to do is ATTACK\"");
                            System.out.println("Hint: Type \"attack\"");
                            gameState = 3;
                        }
                    }
                }
            }

            if(gameState == 1) // Kunesh Sequence
            {
                if(action == 12)
                {
                    player.attack(player.getRoom().getPeople().get(0));
                    player.getRoom().getPeople().get(0).attack(player);
                }

                if(action == 13)
                {
                    System.out.println("Your health is " + player.getHealth());
                    System.out.println("Your defense is " + player.getDefense());
                    System.out.println("Your attack is " + player.getAttack());

                    System.out.println("\nThe enemies health is " + player.getRoom().getPeople().get(0).getHealth());
                }

                if(kunesh.getHealth() <= 5)
                {
                    System.out.println("\"Alright, alright, I give up you bastard. Take the damn hammer, curse you.\"");
                    System.out.println("\nKunesh throws the hammer at your feet, and stumbles towards the tavern for a drink, I guess");

                    kuneshHome.removeEntity(kunesh);
                    tavern.addEntity(kunesh);

                    kunesh.setHealth(15);

                    gameState = 0;
                }
            }

            if(gameState == 3)
            {
                if(action == 12)
                {
                    player.attack(player.getRoom().getPeople().get(0));
                    attacksLeft--;
                    System.out.println("\"Again!\"");
                }
                if(action == 13)
                {
                    System.out.println("Your health is " + player.getHealth());
                    System.out.println("Your defense is " + player.getDefense());
                    System.out.println("Your attack is " + player.getAttack());

                    System.out.println("\nThe enemies health is " + player.getRoom().getPeople().get(0).getHealth());
                }


//                System.out.println("\"That's all from me, Henry. I'm leaving this village today, so as a gift you can keep that sword and those boots. See you around. maybe.\"");
//                gameState = 0;
//                trainingSquare.removeEntity(shadyMan);
//                shadyManLine++;
            }
        }
    }

    public static void introSequence()
    {
        System.out.println("\nYou hear your mother, yelling your name: \n\"Wake up Henry! Wake up! Your dad's looking for you, he neeps help at the forge today!\"");
        System.out.println("\n\"Your clothing is in your chest over there, please put some on before you leave. ALso, stay away from the shady man from the Town Square please. I've heard he's a bandit!\"");
    }

    public static void shadyManSquare()
    {
        System.out.println("\n\"Heyyyy Henry! How's it going? Still sore from last evening? If you want more training you're welcome to join me at the Training Square! \"");
        System.out.println("Type \"Yes\" or \"No\"");
    }

    public static void shadyManTraining()
    {
        System.out.println("\"Alright Henry, all you have to do is hit me\"\n\"All you have to do is ATTACK\"");
        System.out.println("Hint: Type \"attack\"");
    }
}
