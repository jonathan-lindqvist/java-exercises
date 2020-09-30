package exercises.ex2usemoreclasses;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/*

  A class for points in 3D. Should be immutable

  NOTE: No IO here, this is just the logical concept.

  To test run Ex2TestPointTriangle

*/
public class Point {
    // TODO
    // 3d -> x,y,z
    private final int x;
    private final int y;
    private final int z;

    public Point(int x,int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point(Point other){
        this.x = other.getX();
        this.y = other.getY();
        this.z = other.getZ();
    }

    public double distance(Point other){
        int otherX = other.getX();
        int otherY = other.getY();
        int otherZ = other.getZ();
        // Formula for distance between two point in a 3d space, return as int
        return Math.sqrt(Math.pow(otherX-x, 2) + Math.pow(otherY-y,2) + Math.pow(otherZ-z, 2));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}


