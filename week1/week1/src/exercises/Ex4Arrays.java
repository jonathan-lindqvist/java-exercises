package exercises;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * Program to exercise arrays
 *
 * See:
 * - ArrayBasics
 */
public class Ex4Arrays {

    public static void main(String[] args) {
        new Ex4Arrays().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        int[] arr = new int[5];
        int index = -1;

        out.print("Input 5 numbers: ");
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        out.print("Enter value to find: ");
        int value = sc.nextInt();

        for(int i = 0; i<arr.length; i++){
            if( value == arr[i] ){
                index = i;
                out.print("Value (" + value + ") found at index: " + i);
                break;
            }
        }

        if(index == -1){
            out.print("Value not found");
        }

    }
}
