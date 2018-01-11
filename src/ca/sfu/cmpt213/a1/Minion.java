package ca.sfu.cmpt213.a1;

/**
 * Contains properties of a Minion object
 */
public class Minion
{

    private String name;
    private double height;
    private int numEvilDeeds;

    public Minion(String name, double height)
    {
        this.name = name;
        this.height = height;
        this.numEvilDeeds = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getHeight()
    {
        return height;
    }

    public int getNumEvilDeeds()
    {
        return numEvilDeeds;
    }

    public void incrementEvilDeeds()
    {
        numEvilDeeds++;
    }

    @Override
    public String toString()
    {
        return getClass().getName() + ": " + "name= " + this.name + ", height= " + this.height +
                ", Evil Deeds= " + this.numEvilDeeds;
    }
}
