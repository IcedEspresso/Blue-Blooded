package entity.types;

import base.*;
import object.types.*;

public class Player extends GameEntity
{
    public Player(String name, Room room)
    {
        super(name, room);

    }

    public void move(Room room)
    {
        super.setRoom(room);
        System.out.println("You've moved to " + room.getName());
    }

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
