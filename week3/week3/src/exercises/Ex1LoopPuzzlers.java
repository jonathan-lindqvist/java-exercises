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

        for(int i = 1; i < 10; i++){
            int rowTimes = 0;
            while(rowTimes < i){
                out.print("X");
                rowTimes++;
            }
            out.println();
        }


        int nX = 5;
        int spaces = 0;
        for(int times = 0; times < 10; times++){
            for(int i = 0; i < spaces; i++){
                out.print(" ");
            }
            spaces++;
            for(int j = 0; j < nX; j++){
                out.print("X");
            }
            out.println("");
        }

    }
}
