package base;

public abstract class GameObject()
{
    private String name;
    //private Boolean takeable;

    public GameObject(String name)
    {
        this.name = name;
    }

    public void use();
    public void look();
}
