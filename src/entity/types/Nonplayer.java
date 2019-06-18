package entity.types;

import base.*;

public class Nonplayer extends GameEntity
{
    private String type; //Invulnerable, aggressive, passive

    public Nonplayer(String name, Room room, String type)
    {
        super(name, room);
        this.type = type;
        if(type.equals("invulnerable") || type.equals("passive") || type.equals("aggressive"))
        {
            this.type = type;
        }
        else
        {
            throw new ArithmeticException("Invalid NPC type");
        }
    }


    /**
     * Allows the entity to take an object and add it to its inventory ArrayList
     * @param obj object to be taken by the entity
     */
    public void take(GameObject obj)
    {
        if(obj.isTakeable())
        {
            getInventory().add(obj);

            int objIndex = -1;
            for(int i = 0; i<getRoom().getList().size(); i++)
            {
                if(getRoom().getList().get(i) == obj)
                {
                    objIndex = i;
                }
            }

            if(!getRoom().getList().get(objIndex).getIsContained())
            {
                getRoom().getList().remove(getRoom().getList().get(objIndex));
            }
            else {
                getRoom().getList().get(objIndex).getContainer().removeObject(obj);
                getRoom().getList().remove(getRoom().getList().get(objIndex));
            }
            //System.out.println("You took the " + obj.getName());
        }
        else
        {
            //System.out.println("You cannot take that");
            throw new ArithmeticException("NPCs can't have that, something's wrong with the code!");
        }
    }

    public String toString()
    {
        return getName();
    }
}
