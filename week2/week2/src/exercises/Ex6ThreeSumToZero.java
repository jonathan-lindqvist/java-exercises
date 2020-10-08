package exercises;

import java.util.Arrays;

import static java.lang.System.out;

/*
    Find three elements in sorted array that adds up to 0.
    Return indices to the elements as an array.

 */
public class Ex6ThreeSumToZero {

    public static void main(String[] args) {
        new Ex6ThreeSumToZero().program();
    }


    void program() {
        int[] arr1 = {-25, -10, -7, -3, 2, 4, 8, 10}; // Must be sorted
        int[] arr2 = {0, 1, 2, 4, 8, 10};
        int[] arr3 = {-2, 1, 1};
        int[] arr4 = {0, 0, 0, 0};

        out.println(Arrays.toString(getThreeSum(arr1)));    // [1, 4, 6]
        out.println(Arrays.toString(getThreeSum(arr2)));    // []
        out.println(Arrays.toString(getThreeSum(arr3)));    // [0, 1, 2]
        out.println(Arrays.toString(getThreeSum(arr4)));    // [ 0, 1 ,3 ] or any
    }

    int[] getThreeSum(int[] arr){
        int[] threeIndices = new int[3];
        for(int i = 0; i < arr.length; i++){
            for (int j = i+1; j < arr.length; j++){
                int lastNum = 10-makePosifNeg(arr[i] + arr[j]);
                int ree = Arrays.asList(arr).indexOf(lastNum); // does not work because we have int array and not Integer array
                //out.println(ree);
                // wtf
                if(ree != -1 ){
                    if(arr[ree] + arr[i] + arr[j] == 0){
                        threeIndices[0] = i;
                        threeIndices[1] = j;
                        threeIndices[2] = ree;
                        return threeIndices;
                    }
                }
            }
        }
        return threeIndices;
    }
    int makePosifNeg(int i){
        if(i < 0){
            return -i;
        }else{
            return i;
        }
    }


}
