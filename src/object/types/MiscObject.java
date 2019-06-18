package object.types;

import base.*;

public class MiscObject extends GameObject
{
    //There are a lot of useless methods simply because MiscObjects are only there to serve as quest items, currently
    //The only existing example in this prototype is coal

    public MiscObject(String name, boolean takeable)
    {
        super(name, takeable);
    }

    /**
     * Useless
     */
    public void use()
    {
        System.out.println("Cannot use a miscellaneous");
    }

    /**
     * A slightly more detail toString meant for player experience
     */
    public void look()
    {
        System.out.println("It's a " + getName());
    }

    /**
     * Useless
     */
    public void open()
    {
        System.out.println("Cannot open a miscellaneous");
    }

    /**
     * Useless
     */
    public void close()
    {
        System.out.println("Cannot close a miscellaneous");
    }

    /**
     * Useless, as MiscObjects cannot be created
     */
    public boolean isEquipped()
    {
        return false;
    }

    public String toString()
    {
        return getName();
    }
}
