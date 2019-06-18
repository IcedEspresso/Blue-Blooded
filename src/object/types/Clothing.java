package object.types;

import base.*;

public class Clothing extends GameObject
{
    private int protection;
    private StorageObject container;
    private String type;
    private boolean equipped;
    String[] clothingTypes = new String[]{"head", "torso", "legs", "feet"};


    public Clothing(String name, int protection, String type)
    {
        super(name, true);
        this.protection = protection;

        this.type = "Not Applicable";
        for(int i = 0; i < clothingTypes.length; i++)
        {
            if(type.equals(clothingTypes[i]))
            {
                this.type = clothingTypes[i];
            }
        }
        if(this.type.equals("Not Applicable"))
        {
           throw new ArithmeticException("Unsupported Type");
        }

        setType(type);
    }

    /**
     * @return returns the protection variable of the clothing object
     */
    public int getProtection()
    {
        return protection;
    }

    /**
     * Does nothing
     */
    public void use()
    {
        System.out.println("Clothing cannot be used");
    }

    /**
     * @return Returns if this clothing object has been equipped already
     */
    public boolean isEquipped()
    {;
        return equipped;
    }

    /**
     * Sets the equipped state of the object
     * @param x new state for equipped
     */
    public void setEquipped(boolean x)
    {
        equipped = x;
    }

    /**
     * does nothing
     */
    public void open()
    {
        System.out.println("Clothing cannot be opened");
    }

    /**
     * does nothing
     */
    public void close()
    {
        System.out.println("Clothing cannot be closed");
    }

    /**
     * Prints out the object's name and its details (protection)
     */
    public void look()
    {
        System.out.println("It's a " + getName() + ", it has " + getProtection() + " protection");
    }

    /**
     * Useless
     */
    public void use(GameEntity entity)
    {
        System.out.println("Try wear, equip, unequip or wield instead");
    }

    public String toString()
    {
        return getName();
    }
}
