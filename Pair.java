public class Pair {
    private final int [] arrayForPair;

    public Pair(int leftArgument, int rightArgument)
    {
        this.arrayForPair = new int [2];
        this.arrayForPair[0] = leftArgument;
        this.arrayForPair[1] = rightArgument;
    }
    public int[] returnPair()
    {
        return this.arrayForPair;
    }

    public int getLeft()
    {
        return this.arrayForPair[0];
    }

    public int getRight()
    {
        return this.arrayForPair[1];
    }

    public boolean isIdenticalPair(Pair otherPair)
    {
        return (this.arrayForPair[0] == otherPair.getLeft()) && (this.arrayForPair[1] == otherPair.getRight());
    }

}
