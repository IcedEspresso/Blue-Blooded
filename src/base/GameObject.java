package base;

public abstract class GameObject
{
    private String name;
    private boolean takeable;

    public GameObject(String name, boolean takeable)
    {
        this.name = name.toLowerCase();
        this.takeable = takeable;
    }

    public String getName()
    {
        return name;
    }

    public abstract void use();
    public abstract void look();
    public abstract String toString();
}
