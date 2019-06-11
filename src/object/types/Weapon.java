package object.types;

import base.GameObject;

public class Weapon extends GameObject
{
    private int damage;
    //private int durability;

    public Weapon(String name, int damage)
    {
        super(name, true);
        this.damage = damage;
    }

    public void use()
    {
        System.out.println("Unusuable");
    }

    public void look()
    {
        System.out.println("It's a " + getName() + " it can deal " + damage + " damage");
    }

    public String toString()
    {
        return getName();
    }
}
