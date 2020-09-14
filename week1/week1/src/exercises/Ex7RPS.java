package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * The Rock, paper, scissor game.
 * See https://en.wikipedia.org/wiki/Rock%E2%80%93paper%E2%80%93scissors
 *
 * This is exercising smallest step programming (no methods needed)
 *
 * Rules:
 *
 *       -----------  Beats -------------
 *       |                              |
 *       V                              |
 *      Rock (1) --> Scissors (2) --> Paper (3)
 *
 */
public class Ex7RPS {

    public static void main(String[] args) {
        new Ex7RPS().program();
    }

    final Random rand = new Random();
    final Scanner sc = new Scanner(in);

    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int result;         // Result for this round
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds

        // All code here ... (no method calls)

        out.println("Welcome to Rock, Paper and Scissors");

        // TODO Write the game here. Use smallest step then surround with loop!!!!
        while(round < maxRounds){
            out.println("Round " + (round+1));
            out.println("Pick (1) Rock, (2) Scissor or (3) Paper: ");
            human = sc.nextInt();
            computer = rand.nextInt(3)+1;
            out.println("Computer chose: " + computer);
            if(computer+1 == human || computer-2 == human){
                out.println("Computer won this round!");
                result = -1;
            }else if(human+1 == computer || human-2 == computer){
                out.println("You won this round!");
                result = 1;
            }else{
                out.println("This round is a draw!");
                result = 0;
            }
            total += result;
            round++;


        }

        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}
