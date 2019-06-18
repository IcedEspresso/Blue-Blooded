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

    /**
     * @return returns if the weapon is equipped
     */
    public boolean isEquipped()
    {
        return equipped;
    }

    /**
     * Sets the equipped state of the weapon
     * @param x new state
     */
    public void setEquipped(boolean x)
    {
        equipped = x;
    }

    /**
     * @return returns the weapon's damage rating
     */
    public int getDamage()
    {
        return damage;
    }

    /**
     * Useless
     */
    public void use()
    {
        System.out.println("Weapons cannot be used");
    }

    /**
     * Useless
     */
    public void open()
    {
        System.out.println("Weapons cannot be opened");
    }

    /**
     * Useless
     */
    public void close()
    {
        System.out.println("Weapons cannot be closed");
    }

    /**
     * Provides a detailed explanation on the item
     */
    public void look()
    {
        System.out.println("It's a " + getName() + ", it can deal " + damage + " damage");
    }

    public String toString()
    {
        return getName();
    }
}
