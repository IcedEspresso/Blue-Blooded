package base;

import object.types.*;

public abstract class GameObject
{
    private String name;
    private Room currentRoom;
    private boolean takeable;
    private StorageObject container;
    private boolean isContained = false;
    private String type;

    public GameObject(String name, boolean takeable)
    {
        this.name = name.toLowerCase();
        this.takeable = takeable;
    }

    /**
     * @return returns if the object can be taken by an entity
     */
    public boolean isTakeable()
    {
        return takeable;
    }

    /**
     * Sets if an object can be taken
     * @param x takeable's new boolean
     */
    public void setTakeable(boolean x)
    {
        takeable = x;
    }

    /**
     * Sets an object's room
     * @param room Room that the object is supposed to go to
     */
    public void setRoom(Room room)
    {
        currentRoom = room;
    }

    /**
     * @return Returns an object's current room
     */
    public Room getRoom()
    {
        return currentRoom;
    }

    /**
     * sets the type of an object
     * @param type type for the object to be changed to
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * @return returns the type of the object
     */
    public String getType()
    {
        return type;
    }

    /**
     * sets a container for the object
     * @param container new StorageObject for the object to be KNOWN to be contained in
     */
    public void setContainer(StorageObject container)
    {
        this.container = container;
        isContained = true;
    }

    /**
     * @return returns if the object is contained in a container
     */
    public boolean getIsContained()
    {
        return isContained;
    }

    /**
     * @return returns an object's current container
     */
    public StorageObject getContainer()
    {
        return container;
    }

    /**
     * @return returns an object's name
     */
    public String getName()
    {
        return name.substring(0,1).toUpperCase() + name.substring(1);
    }

    public abstract void use();
    public abstract void look();
    public abstract void open();
    public abstract void close();
    public abstract boolean isEquipped();
    public abstract String toString();


}
