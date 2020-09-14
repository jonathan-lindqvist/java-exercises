package exercises;

import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Program to calculate sum and average for non-negative integers
 *
 * See:
 * - Loops (while only)
 * - LoopAndAHalf
 *
 */
public class Ex3SumAvg {

    public static void main(String[] args) {
        new Ex3SumAvg().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // Write your code here
        int sum = 0;
        double avg = 0;
        int times = 0;

        // -- Input (and bookkeeping)
        out.print("Enter your number: ");
        int number = sc.nextInt();

        // -- Process---
        while (number != -1){
            if(number == -1){
                break;
            }
            sum += number;
            times += 1;
            out.print("Enter another number: ");
            number = sc.nextInt();

        }
        avg = (double) sum / times;


        // -- Output ----
        out.print("Sum: " + sum + " Avg: " + avg);
    }

}
