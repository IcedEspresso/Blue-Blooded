package base;

import object.types.*;

import java.util.*;

public class Test
{
    public static Scanner sc;
    public static void main(String[] args)
    {
        sc = new Scanner(System.in);

        Room dev = new Room("dev");
        System.out.println("Room created");

        GameObject chest = new StorageObject("Chest", true);
        System.out.println("Cnest created");
        GameObject lockedChest = new StorageObject("Locked Chest", false);
        System.out.println("Locked Chest created");
        dev.addObject(chest);
        System.out.println("Chest added");
        dev.addObject(lockedChest);
        System.out.println("Locked Chest added");
        System.out.println(dev);

        GameObject stick = new Weapon("Wooden Stick", 1);
        ((StorageObject) chest).addObject(stick);

        chest.use();
        chest.look();
    }
}
