package ca.sfu.cmpt213.a1;

/**
 * Class of the Minion object.
 * @author Steven Le
 */
public class Minion
{

    private String name;
    private double height;
    private int numEvilDeeds;

    /**
     * Minion constructor
     * @param name
     * @param height
     */
    public Minion(String name, double height)
    {
        this.name = name;
        this.height = height;
        this.numEvilDeeds = 0;
    }

    /**
     * Method that returns the minion's name.
     * @return
     */
    public String getName()
    {
        return name;
    }

    /**
     * Method that returns the minion's height.
     * @return
     */

    public double getHeight()
    {
        return height;
    }

    /**
     * Method that returns the minion's evil deed count.
     * @return
     */
    public int getNumEvilDeeds()
    {
        return numEvilDeeds;
    }

    /**
     * Method that increments minion's evil deed count.
     */
    public void incrementEvilDeeds()
    {
        numEvilDeeds++;
    }

    /**
     * Overrided method to print the Minion object's properties.
     * @return
     */
    @Override
    public String toString()
    {
        return getClass().getName() + ": " + "Name: " + this.name + ", Height: " + this.height +
                ", Evil Deeds: " + this.numEvilDeeds;
    }
}
