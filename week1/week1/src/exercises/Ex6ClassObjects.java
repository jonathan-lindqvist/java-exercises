package exercises;

import samples.ClassObjects;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using class objects to represent heroes
 *  https://en.wikipedia.org/wiki/Gladiators_(1992_UK_TV_series)
 *
 * See:
 * - ClassObjects
 * - MethodsArrObj
 */
public class Ex6ClassObjects {

    public static void main(String[] args) {
        new Ex6ClassObjects().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
       Hero hero1 = new Hero();
       out.print("What is name of hero 1? : ");
       hero1.name = sc.nextLine();
       out.print("How strong is " + hero1.name + "? : ");
       hero1.strength = sc.nextInt();
       sc.nextLine();

       Hero hero2 = new Hero();
       out.print("What is name of hero 2? : ");
       hero2.name = sc.nextLine();
       out.print("How strong is " + hero2.name + "? : ");
       hero1.strength = sc.nextInt();
       sc.nextLine();


       if(hero1.strength > hero2.strength){
           out.print(hero1.name + " is stronger");
       }else{
           out.print(hero2.name + " is stronger");
       }
    }

    // ------ The class to use  -----------
    // A class for objects that describes a Hero
    class Hero {
        String name;
        int strength;
    }


}
