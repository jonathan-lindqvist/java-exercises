package exercises;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

/*
 * Implement generic versions of shuffle and sort
 *
 *  See:
 *  - WrapperTypes
 *  - GenericMethod
 */
public class Ex6GenericMethods {

    public static void main(String[] args) {
        new Ex6GenericMethods().program();
    }

    final Random rand = new Random();

    void program() {
        out.println();

        // Working with wrapper types, generic methods only work with reference types
        Integer[] is = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String origIs = Arrays.toString(is);
        String[] ss = {"a", "b", "c", "d", "e"};
        String origSS = Arrays.toString(ss);

        /*
        out.println(is[4].compareTo(is[0]));
        out.println("e".compareTo("a"));
        out.println(ss[1].compareTo(ss[0]));
        out.println(ss[0].compareTo(ss[1]));
        out.println(is[0].compareTo(is[0]));
        out.println(is[1].compareTo(is[0]));
        out.println(is[0].compareTo(is[1]));
         */

        // diffIndex works for all arrays reference types
        out.println(diffIndex(is, is) == -1);
        out.println(diffIndex(ss, ss) == -1);

        // shuffle should be a generic method, so we can use it for Integers ...
        shuffle(is);
        out.println(!Arrays.toString(is).equals(origIs));  // May be false, but unlikely
        // ... and here for String.
        shuffle(ss);
        out.println(!Arrays.toString(ss).equals(origSS));

        // sort should also be generic (this is hard)
        sort(is);
        out.println(Arrays.toString(is).equals(origIs));
        sort(ss);
        out.println(Arrays.toString(ss).equals(origSS));

    }

    // ------- Methods -------------------------
    <T> int diffIndex(T[] arr1, T[]arr2){
        int diffIndex = -1;
        int arrLength = Math.min(arr1.length, arr2.length);
        for(int i = 0; i < arrLength; i++){
            if(arr1[i] != arr2[i]){
                diffIndex = i;
            }
        }

        return diffIndex;
    }

    <T> void shuffle(T[] arr){
        for(int i = 0; i < arr.length; i++){
            int randomIndex = rand.nextInt(arr.length);
            T temp = arr[randomIndex];
            arr[randomIndex] = arr[i];
            arr[i] = temp;
        }
    }

    <T extends Comparable<T>> void sort(T[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j].compareTo(arr[j+1]) >= 1){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
