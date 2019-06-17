package base;
import java.util.*;

public class Room
{
    private String name;
    ArrayList<GameObject> roomItems = new ArrayList<GameObject>();

    public Room(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void addObject(GameObject object)
    {
        roomItems.add(object);
        object.setRoom(this);
    }

    public void removeObject(GameObject object)
    {
        roomItems.remove(object);
        object.setRoom(new Room("Container"));
    }

    public ArrayList<GameObject> getList()
    {
        return roomItems;
    }

    public GameObject getObject(int i)
    {
        return roomItems.get(i);
    }

    public String toString()
    {
        String itemList = "";
        for(int i = 0; i < roomItems.size(); i++)
        {
            if(i > 0)
            {
                itemList += " and ";
            }
            itemList += roomItems.get(i).toString();
        }
        return "You see " + itemList;
    }
}
