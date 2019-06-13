package entity.types;

import base.*;

public class Player extends GameEntity
{
    public Player(String name, Room room)
    {
        super(name, room);
    }

    public void move(Room room)
    {
        super.setRoom(room);
        System.out.println("You've moved to " + room.getName());
    }

    public String toString()
    {
        return getName();
    }
}
