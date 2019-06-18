package base;
import java.util.*;

public class Room
{
    private String name;
    ArrayList<GameObject> roomItems = new ArrayList<GameObject>();
    ArrayList<GameEntity> people = new ArrayList<GameEntity>();

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

    public void addEntity(GameEntity entity)
    {
        people.add(entity);
    }

    public void removeEntity(GameEntity entity)
    {
        for(int i = 0; i < people.size(); i++)
        {
            if(people.get(i) == entity)
            {
                people.remove(i);
            }
        }
    }

    public ArrayList<GameObject> getList()
    {
        return roomItems;
    }

    public ArrayList<GameEntity> getPeople()
    {
        return people;
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
        if(itemList.equals(""))
        {
            itemList = "nothing";
        }

        String peopleList = "";
        for(int i = 0; i < people.size(); i++)
        {
            if(i > 0)
            {
                peopleList += " and ";
            }
            peopleList += people.get(i).toString();
        }
        if(peopleList.equals(""))
        {
            peopleList = "no one";
        }

        return "You're in " + getName() + ". You see " + itemList + ". You also see " + peopleList + ".";
    }
}
