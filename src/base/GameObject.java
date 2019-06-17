package base;

import object.types.*;

public abstract class GameObject
{
    private String name;
    private Room currentRoom;
    private boolean takeable;
    private StorageObject container;
    private String type;

    public GameObject(String name, boolean takeable)
    {
        this.name = name.toLowerCase();
        this.takeable = takeable;
    }

    public boolean isTakeable()
    {
        return takeable;
    }

    public void setRoom(Room room)
    {
        currentRoom = room;
    }

    public Room getRoom()
    {
        return currentRoom;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public void setContainer(StorageObject container)
    {
        this.container = container;
    }

    public StorageObject getContainer()
    {
        return container;
    }

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
