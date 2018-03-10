public class Location
{
    private int x;
    private int y;

    public Location(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Object other)
    {
        Location otherLoc = (Location) other;
        if (getX() < otherLoc.getX())
            return -1;
        if (getX() > otherLoc.getX())
            return 1;
        if (getY() < otherLoc.getY())
            return -1;
        if (getY() > otherLoc.getY())
            return 1;
        return 0;
    }


    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
}
