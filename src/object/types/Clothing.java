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

    public int getProtection()
    {
        return protection;
    }

    public void use()
    {
        System.out.println("Clothing cannot be used");
    }

    public boolean isEquipped()
    {;
        return equipped;
    }

    public void setEquipped(boolean x)
    {
        equipped = x;
    }

    public void open()
    {
        System.out.println("Clothing cannot be opened");
    }

    public void close()
    {
        System.out.println("Clothing cannot be closed");
    }

    public void look()
    {
        System.out.println("It's a " + getName() + ", it has " + getProtection() + " protection");
    }

    public void use(GameEntity entity)
    {
        System.out.println("Try wear, equip, unequip or wield instead");
    }

    public String toString()
    {
        return getName();
    }
}
