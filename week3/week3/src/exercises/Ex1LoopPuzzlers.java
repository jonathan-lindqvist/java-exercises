package exercises;

import static java.lang.System.out;

/*
 *  Some puzzlers
 *  General improvement of programming skills
 *
 *  See:
 *  - LoopPuzzler
 */
public class Ex1LoopPuzzlers {

    public static void main(String[] args) {
        new Ex1LoopPuzzlers().program();
    }


    void program() {
        // TODO Write solution (for loops) directly here
        int timesTodo = 1;
        while(timesTodo < 11){
            for(int i = 1; i < 11; i++){
                out.print(" ");
                out.print(i*timesTodo);
                if(i*timesTodo < 10){
                    out.print(" ");
                }
            }
            out.println("");
            timesTodo++;
        }

    }
}
