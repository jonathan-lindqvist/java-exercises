package exercises.ex2usemoreclasses;

import java.util.Arrays;

import static java.lang.Math.sqrt;

/*
      A class for a Triangle in 3D
      Should use Point class and Herons formula

      NOTE: No IO here, this is just the logical concept.

      To test run Ex2TestPointTriangle

*/
public class Triangle {

    // TODO
    private Point cornerA;
    private Point cornerB;
    private Point cornerC;
    private double sideAB;
    private double sideAC;
    private double sideBC;
    private double s;

    public Triangle(Point cornerA, Point cornerB, Point cornerC){
        this.cornerA = cornerA;
        this.cornerB = cornerB;
        this.cornerC = cornerC;

        this.sideAB = cornerA.distance(cornerB);
        this.sideAC = cornerA.distance(cornerC);
        this.sideBC = cornerB.distance(cornerC);

        this.s = (sideAB + sideAC + sideBC) / 2.0;
    }

    public double area(){
        return Math.sqrt(s*(s-sideAC)*(s-sideAB)*(s-sideBC));
    }

}

