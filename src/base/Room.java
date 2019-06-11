package base;
import java.util.*;

public class Room
{
    private String name;
    ArrayList<GameObject> roomItems = new ArrayList<GameObject>;

    public Room(String name)
    {
        this.name = name;
    }

    public void addObject(GameObject object)
    {
        roomItems.add(object);
    }
}
