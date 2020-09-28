package exercises.ex1useaclass;

import static java.lang.Math.abs;

/*
 *    A class representing a rational number
 *
 *    NOTE: No IO here, this is just the logical concept.
 *
 *    Test the class by running Ex1TestRational.
 *
 * See:
 * - useaclass/
 * - UseAMap
 */

public class Rational {

    private final int num;    // rational =  num / denom
    private final int denom;

    // TODO
    public Rational(int num){
        this.num = num;
        this.denom = 1;
    }

    public Rational(int num, int denom){
        int gcd = gcdByEuclidsAlgorithm(num, denom);
        if(gcd < 0){
            gcd *= -1;
        }
        this.num = num/gcd;
        this.denom = denom/gcd;
    }

    public int getNum() {
        return num;
    }

    public int getDenom(){
        return  denom;
    }

    public Rational add(Rational other){
        int gcd = gcdByEuclidsAlgorithm(denom, other.getDenom());
        int tempDenom = denom;
        int tempNum = num;
        int tempOtherDenom = other.getDenom();
        int tempOtherNum = other.getNum();
        while(tempDenom != tempOtherDenom){
            if(tempDenom > tempOtherDenom){
                tempOtherDenom *= gcd;
                tempOtherNum *= gcd;
            }else{
                tempDenom *= gcd;
                tempNum *= gcd;
            }
        }

        return new Rational((tempNum + tempOtherNum), tempDenom);
    }

    private int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }
}

