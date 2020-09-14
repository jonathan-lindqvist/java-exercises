package exercises;

import java.util.Arrays;

import static java.lang.StrictMath.round;
import static java.lang.StrictMath.sqrt;
import static java.lang.System.out;

/*
 * Methods with array/matrix params and/or return value. Implement methods.
 *
 * See:
 * - Matrices
 */
public class Ex3MatrixMethods {

    public static void main(String[] args) {
        new Ex3MatrixMethods().program();
    }

    void program() {
        int[][] m = {           // Hard coded test data
                {-1, 0, -5, 3},
                {6, 7, -2, 0},
                {9, -2, -6, 8},
                {0, 0, 5, -6}
        };

        // TODO uncomment one at a time and implement

        // Return array with all negatives in m
        int[] negs = getNegatives(m);
        out.println(negs.length == 6);
        out.println(Arrays.toString(negs).equals("[-1, -5, -2, -2, -6, -6]")); // Possibly other ordering!

        // Mark all negatives with a 1, others as 0
        // (create matrix on the fly)
        int[][] marked = markNegatives(new int[][]{
                {1, -2, 3,},
                {-4, 5, -6,},
                {7, -8, 9,},
        });
        /* marked should be (don't uncomment)
        { {0, 1, 0},
          {1, 0, 1},
          {0, 1, 0} }
        */
        out.println(Arrays.toString(marked[0]).equals("[0, 1, 0]"));
        out.println(Arrays.toString(marked[1]).equals("[1, 0, 1]"));
        out.println(Arrays.toString(marked[2]).equals("[0, 1, 0]"));

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // Create matrix from array
        int[][] matrix = toMatrix(arr);
        /* matrix should be (don't uncomment)
        { {1, 2, 3},
          {4, 5, 6},
          {7, 8, 9} }
        */
        //plot(matrix);  // If manual inspection
        out.println(Arrays.toString(matrix[0]).equals("[1, 2, 3]"));
        out.println(Arrays.toString(matrix[1]).equals("[4, 5, 6]"));
        out.println(Arrays.toString(matrix[2]).equals("[7, 8, 9]"));

        // Sum of all directly surrounding elements to some element in matrix
        // (not counting the element itself)
        // NOTE: Should be possible to expand method to include more distant neighbours
        out.println(sumNeighbours(matrix, 0, 0) == 11);
        out.println(sumNeighbours(matrix, 1, 1) == 40);
        out.println(sumNeighbours(matrix, 1, 0) == 23);
    }

    // -------- Write methods below this -----------------------

    // TODO Methods here

    // Use if you like (during development)
    void plot(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            out.println(Arrays.toString(matrix[row]));
        }
    }

    int[] getNegatives(int[][]arr){
        int nNegatives = 0;
        for (int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[row].length; col++){
                if(arr[row][col] < 0){
                    nNegatives++;
                }
            }

        }

        int[] negArr = new int[nNegatives];
        for(int negIndex = 0; negIndex < negArr.length; negIndex++){
            for (int row = 0; row < arr.length; row++) {
                for(int col = 0; col < arr[row].length; col++){
                    if(arr[row][col] < 0){
                        negArr[negIndex] = arr[row][col];
                        negIndex++;
                    }
                }

            }
        }

        return negArr;
    }

    int[][] markNegatives(int[][]mat){
        int[][] marked = new int[mat.length][mat[0].length];
        for(int rowIndex = 0; rowIndex < marked.length;rowIndex++){
            for(int colIndex = 0; colIndex <marked[rowIndex].length; colIndex++){
                if(mat[rowIndex][colIndex] < 1){
                    marked[rowIndex][colIndex] = 1;
                }else{
                    marked[rowIndex][colIndex] = 0;
                }
            }
        }
        return marked;
    }

    int[][] toMatrix(int[] arr){
        int[][] matrix = new int[3][3];
        int arrIndex = 0;
        while(arrIndex < arr.length)
            for(int row = 0; row < matrix.length; row++){
                for(int col = 0; col < matrix[row].length; col++){
                    matrix[row][col] = arr[arrIndex];
                    arrIndex++;
            }
        }

        return matrix;
    }

    int sumNeighbours(int[][]matrix,int rowPos,int colPos){
        /*
        [-1,-1][-1,0][-1,1]
        [0,-1 ][0,0 ][0,1 ]
        [1,-1 ][1,0 ][1,1 ]
         */
        int sum = 0;
        for(int rowIndex = -1; rowIndex <=1; rowIndex++){
            for(int colIndex = -1;  colIndex <= 1; colIndex++){
                if(rowIndex + rowPos < matrix.length && rowIndex + rowPos > -1){
                    if(colIndex + colPos < matrix[rowIndex+rowPos].length && colIndex + colPos > -1){
                        if(!(colIndex + colPos == colPos && rowIndex + rowPos == rowPos)) {
                            sum += matrix[rowIndex+rowPos][colIndex+colPos];
                        }
                    }
                }
            }
        }


        return sum;
    }
}
