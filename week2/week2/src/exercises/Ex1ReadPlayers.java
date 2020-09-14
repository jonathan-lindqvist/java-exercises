package exercises;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Utilities to input/output player data for a command line game
 *
 *  See:
 *  - UseAConstructor
 *  - ObjectArrMeth
 *
 */
public class Ex1ReadPlayers {
    public static void main(String[] args) {
        new Ex1ReadPlayers().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        Player[] players = inputPlayers();
        outPlayers(players);
    }

    // This class captures the concept of a Player
    class Player {
        String name;   // A Player has a name and...
        int points;    // ... and points

        // TODO Add a constructor
        Player(String name){
            this.name = name;
        }
    }

    // ---------- Methods -------------------

     Player[] inputPlayers() {
        // TODO
         out.print("How many players? > ");
         int numPlayers = sc.nextInt();
         sc.nextLine();
         Player[] players = new Player[numPlayers];
         for(int i = 0; i < players.length; i++){
             out.print("Name for player " + (i + 1) + " > ");
             players[i] = new Player(sc.nextLine());
         }
        return players;
    }

    void outPlayers(Player[] players){
       out.println("Players are:");
       for(int i = 0;i<players.length;i++){
           out.println("Name " + players[i].name + " points " + (players[i].points));
        }
    }


}
