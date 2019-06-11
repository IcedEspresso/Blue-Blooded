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

    public void addObject(GameObject object)
    {
        roomItems.add(object);
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
