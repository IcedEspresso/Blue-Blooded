package entity.types;

import base.*;
import object.types.*;

public class Player extends GameEntity
{
    public Player(String name, Room room)
    {
        super(name, room);

    }

    /**
     * Moves the player to another room. ADDITIONALLY prints out that the player has been moved in comparison to setRoom
     * @param room room to be moved to
     */
    public void move(Room room)
    {
        super.setRoom(room);
        System.out.println("You've moved to " + room.getName());
    }

    /**
     * Allows the player to add an object into their inventory
     * @param obj object to be taken by the entity
     */
    public void take(GameObject obj)
    {
        if(obj.isTakeable())
        {
            getInventory().add(obj);

            int objIndex = -1;
            for(int i = 0; i<getRoom().getList().size(); i++)
            {
                if(getRoom().getList().get(i) == obj)
                {
                    objIndex = i;
                }
            }
            if(!getRoom().getList().get(objIndex).getIsContained())
            {
                getRoom().getList().remove(getRoom().getList().get(objIndex));
            }
            else {
                getRoom().getList().get(objIndex).getContainer().removeObject(obj);
                getRoom().getList().remove(getRoom().getList().get(objIndex));
            }

            System.out.println("You took the " + obj.getName());
        }
        else
        {
            System.out.println("You cannot take that");
        }
    }

//    public void take(GameObject obj, StorageObject storage)
//    {
//        if (obj.isTakeable()) {
//            getInventory().add(obj);
//            storage.removeObject(obj);
//
//            System.out.println("You took the " + obj.getName());
//        } else {
//            System.out.println("You cannot take that");
//        }
//    }

    /**
     * Prints out a list for the user to easily view what is in their inventory, as well as what is currently equipped
     */
    public void viewInventory()
    {
        System.out.println("You have " + getInventory().size() + " items in your inventory");

        if(getInventory().size() > 0)
        {
            for(int i = 0; i < getInventory().size(); i++) {
                if (getInventory().get(i).isEquipped()) {
                    System.out.println((i + 1) + ". " + getInventory().get(i)  + " [EQUIPPED] ");
                }
                else
                {
                    System.out.println((i + 1) + ". " + getInventory().get(i));
                }
            }
        }
    }

    public String toString()
    {
        return getName();
    }
}
