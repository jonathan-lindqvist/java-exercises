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
        int gcd = commonDenom(num, denom);
        int mod = 1;
        if(num < 0 && denom < 0){
            mod = -1;
        }else if(num > 0 && denom < 0){
            mod = -1;
        }
        this.num = num/gcd * mod;
        this.denom = denom/gcd * mod;
    }

    public int getNum() {
        return num;
    }

    public int getDenom(){
        return  denom;
    }

    public Rational add(Rational other){
        return null;
    }

    private int commonDenom(int n1, int n2) {
        int gcd = 1;
        if(n1 < 0){
            n1 *= -1;
        }
        if(n2 < 0){
            n2 *= -1;
        }
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}

