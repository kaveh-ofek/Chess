/**
 * simple pair class used to save (x,y) coordinates as a location
 */
public class Pair {
    private final int [] arrayForPair;

    /**
     * constructor for new pair
     * @param leftArgument x coordinate
     * @param rightArgument y coordinate
     */
    public Pair(int leftArgument, int rightArgument)
    {
        this.arrayForPair = new int [2];
        this.arrayForPair[0] = leftArgument;
        this.arrayForPair[1] = rightArgument;
    }

    /**
     * The method will return the x coordinate of the pair
     * @return integer
     */
    public int getLeft()
    {
        return this.arrayForPair[0];
    }

    /**
     * The method will return the y coordinate of the pair
     * @return integer
     */
    public int getRight()
    {
        return this.arrayForPair[1];
    }

    /**
     * The method will return whether 2 pairs are having identical values
     * @param otherPair another pair to check with
     * @return boolean value
     */
    public boolean isIdenticalPair(Pair otherPair)
    {
        return (this.arrayForPair[0] == otherPair.getLeft()) && (this.arrayForPair[1] == otherPair.getRight());
    }

}
