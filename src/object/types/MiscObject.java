package object.types;

import base.*;

public class MiscObject extends GameObject
{
    public MiscObject(String name, boolean takeable)
    {
        super(name, takeable);
    }
    public void use()
    {
        System.out.println("Cannot use a miscellaneous");
    }

    public void look()
    {
        System.out.println("It's a " + getName());
    }

    public void open()
    {
        System.out.println("Cannot open a miscellaneous");
    }
    public void close()
    {
        System.out.println("Cannot close a miscellaneous");
    }

    public boolean isEquipped()
    {
        return false;
    }
    public String toString()
    {
        return getName();
    }
}
