package base;

import object.types.*;
import java.util.*;

public abstract class GameEntity
{
    private String name;
    private Room currentRoom;
    private int totalProtection;
    private int weaponDamage;
    private Weapon currentWeapon;

    private Clothing head;
    private Clothing torso;
    private Clothing legs;
    private Clothing feet;

    ArrayList<GameObject> inventory = new ArrayList<GameObject>();

    public GameEntity(String name, Room room)
    {
        this.name = name;
        currentRoom = room;

        totalProtection = 0;
        //Initial Equipment added in main method when the game loads.

        currentWeapon = new Weapon("Fists", 1);
        weaponDamage = currentWeapon.getDamage();

        head = new Clothing("Nothing", 0, "head");
        torso = new Clothing("Nothing", 0, "torso");
        legs = new Clothing("Nothing", 0, "legs");
        feet = new Clothing("Nothing", 0, "feet");
    }

    public void setRoom(Room newRoom)
    {
        currentRoom = newRoom;
    }

    public Room getRoom()
    {
        return currentRoom;
    }

    public String getName()
    {
        return name;
    }

    public abstract void take(GameObject obj);

    public void equip(Clothing equipment)
    {
        boolean inInventory = false;

        for(int i = 0; i < inventory.size(); i++)
        {
            if(equipment.getName().equals(inventory.get(i).getName()))
            {
                inInventory = true;
            }
        }

        if(inInventory) {
            if (head.getName().equals("Nothing") && equipment.getType().equals("head"))
            {
                head = equipment;
                equipment.setEquipped(true);
                totalProtection += equipment.getProtection();
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + equipment.getName());
                }
            } else if (torso.getName().equals("Nothing") && equipment.getType().equals("torso"))
            {
                torso = equipment;
                equipment.setEquipped(true);
                totalProtection += equipment.getProtection();
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + equipment.getName());
                }
            } else if (legs.getName().equals("Nothing") && equipment.getType().equals("legs"))
            {
                legs = equipment;
                equipment.setEquipped(true);
                totalProtection += equipment.getProtection();
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + equipment.getName());
                }
            } else if (feet.getName().equals("Nothing") && equipment.getType().equals("feet"))
            {
                feet = equipment;
                equipment.setEquipped(true);
                totalProtection += equipment.getProtection();
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + equipment.getName());
                }
            } else if (equipment.getType().equals("head"))
            {
                totalProtection -= head.getProtection();
                head.setEquipped(false);
                System.out.println("You unequipped a " + equipment.getName());
                head = equipment;
                totalProtection += head.getProtection();
                head.setEquipped(true);
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + equipment.getName());
                }
            } else if (equipment.getType().equals("torso"))
            {
                totalProtection -= torso.getProtection();
                torso.setEquipped(false);
                System.out.println("You unequipped a " + equipment.getName());
                torso = equipment;
                totalProtection += torso.getProtection();
                torso.setEquipped(true);
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + equipment.getName());
                }
            } else if (equipment.getType().equals("legs"))
            {
                totalProtection -= legs.getProtection();
                legs.setEquipped(false);
                System.out.println("You unequipped a " + equipment.getName());
                legs = equipment;
                totalProtection += legs.getProtection();
                legs.setEquipped(true);
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + equipment.getName());
                }
            } else if (equipment.getType().equals("feet"))
            {
                totalProtection -= feet.getProtection();
                feet.setEquipped(false);
                System.out.println("You unequipped a " + equipment.getName());
                feet = equipment;
                totalProtection += feet.getProtection();
                feet.setEquipped(true);
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + equipment.getName());
                }
            }
        }
        else
        {
            System.out.println("You don't have this item");
        }
    }
    public void equip(Weapon weapon)
    {
        boolean inInventory = false;

        for(int i = 0; i < inventory.size(); i++)
        {
            if(weapon.getName().equals(inventory.get(i).getName()))
            {
                inInventory = true;
            }
        }

        if(inInventory)
        {
            if (currentWeapon.getName().equals("Fists"))
            {
                currentWeapon = weapon;
                weaponDamage = currentWeapon.getDamage();
                currentWeapon.setEquipped(true);
                if (name.equals("Player"))
                {
                    System.out.println("You equipped a " + weapon.getName());
                }
            }
            else
            {
                unequip(currentWeapon);
                equip(weapon);
            }

            weapon.setEquipped(true);
        }
        else
        {
            System.out.println("You don't have this item");
        }
    }

    public void unequip(Weapon weapon)
    {
        if(!currentWeapon.getName().equals("Fists"))
        {
            currentWeapon.setEquipped(false);
            System.out.println("You unequipped " + currentWeapon);
            currentWeapon = new Weapon("Fists", 1);
            weaponDamage = currentWeapon.getDamage();

            weapon.setEquipped(false);
        }
        else
        {
            System.out.println("You're not currently wielding anything");
        }
    }

    public void unequip(Clothing clothing)
    {
        if(clothing.getType().equals("head"))
        {
            if(!head.getName().equals("Nothing"))
            {
                System.out.println("You unequipped " + head.getName());
                head.setEquipped(false);
                head = new Clothing("Nothing", 0, "head");
            }
        }
        else if(clothing.getType().equals("torso"))
        {
            if(!torso.getName().equals("Nothing"))
            {
                System.out.println("You unequipped " + torso.getName());
                torso.setEquipped(false);
                torso = new Clothing("Nothing", 0, "torso");
            }
        }
        else if(clothing.getType().equals("legs"))
        {
            if(!legs.getName().equals("Nothing"))
            {
                System.out.println("You unequipped " + legs.getName());
                legs.setEquipped(false);
                legs = new Clothing("Nothing", 0, "legs");
            }
        }
        else if(clothing.getType().equals("feet"))
        {
            if(!feet.getName().equals("Nothing"))
            {
                System.out.println("You unequipped " + feet.getName());
                feet.setEquipped(false);
                feet = new Clothing("Nothing", 0, "feet");
            }
        }

    }


    public ArrayList<GameObject> getInventory()
    {
        return inventory;
    }

    public abstract String toString();
}
