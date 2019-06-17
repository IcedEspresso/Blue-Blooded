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

    public boolean isOpenable()
    {
        return openable;
    }

    public boolean isOpen()
    {
        return opened;
    }

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

    public void addObject(GameObject x)
    {
        contains.add(x);
        x.setContainer(this);
    }

    public void removeObject(GameObject x)
    {
        contains.remove(x);
        x.setContainer(new StorageObject("Someplace else", false));
    }

    public boolean isEquipped()
    {
        return false;
    }

    public String toString()
    {
        return getName();
    }
}
