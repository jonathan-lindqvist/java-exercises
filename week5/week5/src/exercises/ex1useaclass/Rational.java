package exercises.ex1useaclass;

import java.util.Objects;

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
        // Multiply with each denom on the other denom and num, because the constructor will short the result.
        // prep with numbers
        int otherNum = other.getNum();
        int otherDenom = other.getDenom();

        //Start logic for add below
        int newDenom = denom * otherDenom;
        int newNum = num * otherDenom;

        int newOtherNum = otherNum * denom;
        return new Rational(newNum+newOtherNum,  newDenom);
    }

    public Rational sub(Rational other){
        // Multiply with each denom on the other denom and num, because the constructor will short the result.
        // prep with numbers
        int otherNum = other.getNum();
        int otherDenom = other.getDenom();

        //Start logic for add below
        int newDenom = denom * otherDenom;
        int newNum = num * otherDenom;

        int newOtherNum = otherNum * denom;

        return new Rational(newNum-newOtherNum, newDenom);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rational rational = (Rational) o;
        return num == rational.num &&
                denom == rational.denom;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, denom);
    }
}

