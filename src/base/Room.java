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

    /**
     * @return returns the name of the Room
     */
    public String getName()
    {
        return name;
    }

    /**
     * Adds an object to the ArrayList roomItems of the room
     * @param object object to be added to the arraylist
     */
    public void addObject(GameObject object)
    {
        roomItems.add(object);
        object.setRoom(this);
    }

    /**
     * removes an object from teh arraylist roomItems of the room
     * @param object to be removed from the arraylist
     */
    public void removeObject(GameObject object)
    {
        roomItems.remove(object);
        object.setRoom(new Room("Container"));
    }

    /**
     * adds an entity to the people arraylist of the room
     * @param entity entity to be added to tehe people arraylist
     */
    public void addEntity(GameEntity entity)
    {
        people.add(entity);
    }


    /**
     * removes an entity from the people arraylist of the room
     * @param entity entity to be removes from the people array list
     */
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

    /**
     *
     * @return returns the list of Objects in the room; roomItems
     */
    public ArrayList<GameObject> getList()
    {
        return roomItems;
    }

    /**
     * @return returns the list of Entities in the room; people
     */
    public ArrayList<GameEntity> getPeople()
    {
        return people;
    }

    /**
     * returns an object at int i in roomItems
     * @param i index of the specific object in roomItems
     * @return returns the object at the index i in roomItems
     */
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
