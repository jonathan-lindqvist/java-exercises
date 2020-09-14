package exercises;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/*
 *  The TicTacToe Game
 *  See https://en.wikipedia.org/wiki/Tic-tac-toe.
 *
 *  This is exercising functional decomposition and testing
 *  - Any non trivial method should be tested (in test() method far below)
 *  - IO methods never tested.
 *
 *  NOTE: Just use an array for the board (we print it to look square, see plotBoard())
 *
 */

/*
    TODO:
    Make players switch turns [x]
    Update board depending on their choice [X]
    Make sure they cant select square already marked [X]
    Check if 3 in a row [ ]
    Display winner [ ]

 */
public class Ex9TicTacToe {

    public static void main(String[] args) {
        new Ex9TicTacToe().program();
    }

    final Scanner sc = new Scanner(in);
    final Random rand = new Random();
    final char EMPTY = '-';        // This is so that we easy can change the value in one place

    void program() {
        //test();       // <--------- Comment out to test

        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("fia", 'O');
        Player current = null;         // For now
        Player winner = null;
        char[] board = createBoard();  // alt. { EMPTY, EMPTY, ... }

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);

        // TODO Add game logic here (use smallest step and functional decomposition)
        current = getFirstPlayer(p1,p2);
        int selectionPos = 0;
        boolean marked = true;

        while(winner == null){
            current = switchCurrentPlayer(p1,p2, current);
            while(true){
                selectionPos = getPlayerSelection(current);
                if(board[selectionPos] == EMPTY){
                    board = updateBoard(selectionPos, board, current);
                    break;
                }else{
                    out.println("Pos already taken, pick another one!");
                }
            }
            plotBoard(board);
            winner = checkForWinner(current, board);
        }

        out.println("Game over!");
        plotBoard(board);

        if (winner != null) {
            out.println("Winner is " + current.name);
        } else {
            out.println("Draw");
        }
    }


    // ---------- Methods below this ----------------

    // TODO More methods

    char[] createBoard() {
        char[] board = new char[9];
        for (int i = 0; i < board.length; i++) {
            board[i] = EMPTY;
        }
        return board;
    }

    int getPlayerSelection(Player player) {
        int selection;
        while (true) {
            out.println("Player is " + player.name + "(" + player.mark + ")");
            out.print("Select position to put mark (0-8) > ");
            selection = sc.nextInt();
            if (0 <= selection && selection <= 8) {
                break;
            }
            out.println("Bad choice (0-8 allowed)");
        }
        return selection;
    }

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    Player getFirstPlayer(Player p1, Player p2){
        int num = rand.nextInt(2) + 1;
        if(num == 1){
            return p1;
        }else{
            return p2;
        }
    }

    Player switchCurrentPlayer(Player p1, Player p2, Player current){
        if(current == p1){
            current = p2;
        }else{
            current = p1;
        }
        return current;
    }

    char[] updateBoard(int selectionPos, char[] board, Player current){
        board[selectionPos] = current.mark;
        return board;
    }

    // redundant code, can be a lot better, for example check diagonal and broken into smaller functions
    Player checkForWinner(Player current, char[] board){
        Player winner = null;
        // check rows
        int y_index = 0;
        while(y_index < 7){ // less than 7 because rows start at index 0, 3 and 6
            if(board[y_index] == current.mark && board[y_index+1] == current.mark && board[y_index+2] == current.mark){
                winner = current;
            }
            y_index += 3;
        }

        //check columns
        int x_index = 0;
        while(x_index < 3){
            if(board[x_index] == current.mark && board[x_index+3] == current.mark && board[x_index+6] == current.mark){
                winner = current;
            }
            x_index++;
        }

        // check diagonal
        if(board[0] == current.mark && board[4] == current.mark && board[8] == current.mark){
            winner = current;
        }else if(board[2] == current.mark && board[4] == current.mark && board[6] == current.mark){
            winner = current;
        }

        return winner;
    }

    // A class (blueprint) for players.
    class Player {
        String name;
        char mark;
        Player(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }
    }

    // This is used to test methods in isolation
    // Any non trivial method should be tested.
    // If not ... can't build a solution out of possible failing parts!
    void test() {
        char[] b = createBoard();
        out.println(b.length == 9);

        // TODO More tests

        exit(0);
    }
}