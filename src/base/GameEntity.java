package base;

public abstract class GameEntity
{
    private String name;
    private Room currentRoom;

    public GameEntity(String name, Room room)
    {
        this.name = name;
        currentRoom = room;
    }

    public void setRoom(Room newRoom)
    {
        currentRoom = newRoom;
    }

    public String getName()
    {
        return name;
    }

    public abstract String toString();
}
