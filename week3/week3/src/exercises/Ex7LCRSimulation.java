package exercises;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.exit;
import static java.lang.System.out;

/*
 *  Simulation of LCR game. See, https://en.wikipedia.org/wiki/LCR_(dice_game)
 */
public class Ex7LCRSimulation {

    public static void main(String[] args) {
        new Ex7LCRSimulation().program();
    }

    final Random rand = new Random();

    void program() {
        //test();        // < --- Uncomment to run tests ---

        // Hard coded data
        final Player[] players = {new Player("olle", 3),
                new Player("fia", 3), new Player("pelle", 3)};
        Player actual = players[0];
        out.println("Simulation starts");
        displayPlayers(players);

        // TODO Runt the simulation
        boolean gameOver = false;
        while(!gameOver){
            char[] diceForActual = rollDices(actual);
            updateHands(actual, diceForActual, players);
            displayState(actual, diceForActual, players);
            gameOver = checkForWinner(players);
            actual = updateActual(actual, players);
        }
    }



    // ---- Logical methods -----------------

    // TODO
    char[] rollDices(Player actual){
        char[] dice = {'.', '.', '.', 'L', 'C', 'R'};
        int times = Math.min(actual.chips, 3);
        StringBuilder rolls = new StringBuilder();
        while(times>0){
            rolls.append(dice[rand.nextInt(dice.length)]);
            times--;
        }
        return rolls.toString().toCharArray();

    }

    private void updateHands(Player actual, char[] diceForActual, Player[] players) {
        int index = indexOfActual(actual, players);
        for(char c : diceForActual){
            if(c == 'L'){
                if(index == 0){
                    players[players.length-1].chips++;
                }else{
                    players[index-1].chips++;
                }
                actual.chips--;
            }else if(c == 'R'){
                players[(index+1)%players.length].chips++;
                actual.chips--;
            }else if(c == 'C'){
                actual.chips--;
            }
        }
    }

    private boolean checkForWinner(Player[] players) {
        int playersWithNoChips = 0;
        for(Player p : players){
            if(p.chips == 0){
                playersWithNoChips++;
            }
        }
            return playersWithNoChips == players.length - 1;
    }

    private Player updateActual(Player actual, Player[] players) {
        int index = indexOfActual(actual, players);
        Player newActual = players[(index+1)% players.length];
        while(newActual.chips == 0){
            index++;
            newActual = players[(index+1)% players.length];
        }
        return newActual;
    }

    private int indexOfActual(Player actual, Player[] players) {
        for(int i = 0; i < players.length; i++){
            if(actual.equals(players[i])){
                return i;
            }
        }
        return -1;
    }

    // --- IO methods ------------------

    void displayState(Player actual, char[] result, Player[] players) {
        out.print(actual.name + " got ");
        out.println(Arrays.toString(result));
        displayPlayers(players);
    }

    void displayPlayers( Player[] players ){
         for (int i = 0; i < players.length; i++) {
            out.print(players[i].name + ":" + players[i].chips + " ");
        }
        out.println();
    }

    // ------- Class to hold player data -----------

    class Player {
        String name;
        int chips;

        public Player(String name, int chips) {
            this.name = name;
            this.chips = chips;
        }
    }

    // ********************** Testing *************************************''

    void test() {
        // Local hard coded test data
        Player[] players = {new Player("1", 1),
                new Player("2", 2), new Player("3", 3)};

        // TODO Testing

        exit(0);
    }
}
