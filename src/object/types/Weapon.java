package object.types;

import base.GameObject;

public class Weapon extends GameObject
{
    private int damage;
    private boolean equipped;
    //private int durability;

    public Weapon(String name, int damage)
    {
        super(name, true);
        this.damage = damage;
        setType("weapon");
    }

    public boolean isEquipped()
    {
        return equipped;
    }

    public void setEquipped(boolean x)
    {
        equipped = x;
    }

    public int getDamage()
    {
        return damage;
    }

    public void use()
    {
        System.out.println("Weapons cannot be used");
    }

    public void open()
    {
        System.out.println("Weapons cannot be opened");
    }

    public void close()
    {
        System.out.println("Weapons cannot be closed");
    }

    public void look()
    {
        System.out.println("It's a " + getName() + ", it can deal " + damage + " damage");
    }

    public String toString()
    {
        return getName();
    }
}
