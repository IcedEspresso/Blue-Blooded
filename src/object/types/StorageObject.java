package object.types;

import java.util.*;
import base.GameObject;

public class StorageObject extends GameObject
{
    private boolean openable;
    private boolean opened;

    private ArrayList<GameObject> contains = new ArrayList<>();

    public StorageObject(String name, boolean openable)
    {
        super(name, false);
        this.openable = openable;
    }

    /**
     * @return if the storage object can be opened
     */
    public boolean isOpenable()
    {
        return openable;
    }

    /**
     * @return if the storage object is open
     */
    public boolean isOpen()
    {
        return opened;
    }

    /**
     * Allows the user to open the storage object if possible, allowing the objects inside to become accessible and taken
     */
    public void open()
    {
        if(openable)
        {
            if(opened)
            {
                System.out.println("This " + getName() + " is already open");
            }
            else
            {
                System.out.println("You've opened the " + getName());
                opened = true;
                for(int i = 0; i < contains.size(); i++)
                {
                    getRoom().addObject(contains.get(i));
                }
            }
        }
        else
        {
            System.out.println("This " + getName() + " cannot be opened.");
        }
    }

    /**
     * Closes the StorageObject, limiting access to the items from the player
     */
    public void close()
    {
        if(opened)
        {
            System.out.println("You closed the " + getName());
            opened = false;
            for(int i = 0; i < contains.size(); i++)
            {
                for(int j = 0; j < getRoom().getList().size(); j++)
                {
                    if(contains.get(i) == getRoom().getObject(j))
                    {
                        getRoom().removeObject(getRoom().getList().get(j));
                    }
                }
            }
        }
        else
        {
            System.out.println("It's already closed");
        }
    }

    /**
     * Alternative, and simplified command to both open and close a storage container
     */
    public void use()
    {
        if(opened)
        {
            close();
        }
        else
        {
            open();
        }
    }

    /**
     * Provides detail on the object, also prints out items inside the storageobject if it is OPEN
     */
    public void look()
    {
        System.out.println("It's a " + getName());
        if(opened)
        {
            String itemList = "";
            for(int i = 0; i < contains.size(); i ++)
            {
                if(i > 0)
                {
                    itemList += " and ";
                }
                itemList += contains.get(i).toString();
            }

            if(itemList == "")
            {
                itemList = "nothing";
            }

            System.out.println("You see " + itemList + " inside");
        }
    }

    /**
     * Adds an object to the contents of its contains ArrayList
     * @param x object to be added to a StorageObject's arraylist
     */
    public void addObject(GameObject x)
    {
        contains.add(x);
        x.setContainer(this);
    }

    /**
     * Removes an object from the contents of its contains ArrayList
     * @param x object to be removed from a StorageObject arraylist
     */
    public void removeObject(GameObject x)
    {
        contains.remove(x);
        x.setContainer(new StorageObject("Someplace else", false));
    }

    /**
     * Useless
     */
    public boolean isEquipped()
    {
        return false;
    }

    public String toString()
    {
        return getName();
    }
}
