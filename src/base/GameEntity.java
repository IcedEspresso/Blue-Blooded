package base;

import object.types.*;
import java.util.*;

public abstract class GameEntity
{
    private String name;
    private int health = 50;
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

    /**
     * Sets the room of a GameEntity, used for moving entities that are not the player
     * @param newRoom the new room the entity will be in
     */
    public void setRoom(Room newRoom)
    {
        currentRoom = newRoom;
    }

    /**
     * @return returns the entity's current room
     */
    public Room getRoom()
    {
        return currentRoom;
    }

    /**
     * @return returns name of the entity
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return returns health of the entity
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * @return returns weaponDamage of the entity
     */
    public int getAttack()
    {
        return weaponDamage;
    }

    /**
     * @return returns totalProtection of the entity
     */
    public int getDefense()
    {
        return totalProtection;
    }

    /**
     * Sets the health of an entity
     * @param newHealth an int that will replace the int of the current health of the entity
     */
    public void setHealth(int newHealth)
    {
        health = newHealth;
    }

    /**
     * "Attacks" another entity, causing them to lose health based on this entity's weapon
     * @param target The entity to be attacked
     */
    public void attack(GameEntity target)
    {
        target.setHealth(target.getHealth() - weaponDamage);

        if(target.getName().toLowerCase().equals("player"))
        {
            System.out.println("You took " + weaponDamage + " damage!");
        }
        else
        {
            System.out.println("You dealt " + weaponDamage + " damage!");
        }
    }

    /**
     * Allows entities to take an object, and put it in its inventory arraylist
     * @param obj object to be taken by the entity
     */
    public abstract void take(GameObject obj);

    /**
     * Allows entities to wear, or equip clothing. Will add to the entity's total protection based on the equipment's defense variable
     * @param equipment a Clothing object, will be worn by the entity
     */
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
                System.out.println("You unequipped a " + head.getName());
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
                System.out.println("You unequipped a " + torso.getName());
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
                System.out.println("You unequipped a " + legs.getName());
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
                System.out.println("You unequipped a " + feet.getName());
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

    /**
     * Allows the entity to equip a weapon, replaces weaponDamage as well
     * @param weapon the weapon the entity is going to use
     */
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

    /**
     * replaces the current weapon with fists, as well as weapon damage with int 1
     * @param weapon the weapon to be unequipped
     */
    public void unequip(Weapon weapon)
    {
        if(!currentWeapon.getName().equals("Fists"))
        {
            currentWeapon.setEquipped(false);
            System.out.println("You unequipped " + currentWeapon);
            currentWeapon = new Weapon("Fists", 1);
            weaponDamage = currentWeapon.getDamage();

            weapon.setEquipped(true);
        }
        else
        {
            System.out.println("You're not currently wielding anything");
        }
    }

    /**
     * Replace the current clothing in an area (head, torso, legs, feet) with "nothing", as well as lowering totalProtection
     * @param clothing clothing to be removed
     */
    public void unequip(Clothing clothing)
    {
        totalProtection -= clothing.getProtection();

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

    /**
     * @return returns the entities inventory
     */
    public ArrayList<GameObject> getInventory()
    {
        return inventory;
    }

    public abstract String toString();
}
