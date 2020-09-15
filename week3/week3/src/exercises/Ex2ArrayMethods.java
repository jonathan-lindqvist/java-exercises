package exercises;

import java.util.Arrays;

import static java.lang.System.*;

/*
 *  Some harder array methods
 */
public class Ex2ArrayMethods {


    public static void main(String[] args) {
        new Ex2ArrayMethods().program();
    }

    void program() {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};

        // Rotate all elements in the arr k steps to the right (in a circular fashion)
        // Assume arr.length > 0. NOTE: Original array changed!
        arr1 = rotate(arr1, 3);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        arr1 = rotate(arr1, 0);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        arr1 = rotate(arr1, arr1.length);
        out.println(Arrays.toString(arr1).equals("[6, 7, 8, 1, 2, 3, 4, 5]"));
        rotate(new int[]{1}, 3);
        //Changed to "arr1 = " because it needs the returned value to change it?
        // Ask how to do it without the assigning

        // Same as above but here we have a return value
        int[] r = rotate2(new int[]{1, 2, 3, 4, 5}, 2);  // Return value!
        out.println(Arrays.toString(r).equals("[4, 5, 1, 2, 3]"));
        r = rotate2(new int[]{1, 2, 3, 4, 5}, 5);  // Return value!
        out.println(Arrays.toString(r).equals("[1, 2, 3, 4, 5]"));


        int[] arr2 = {1, 2, 2, 3, 3};   // All sorted in increasing order
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 1, 1, 1, 1, 1};
        int[] arr5 = {1};

        // Remove all duplicates from arr2, ... (original unchanged, copy created)
        // NOTE: Assume arr is sorted in increasing order and > 0
        out.println(Arrays.toString(removeDupl(arr2)).equals("[1, 2, 3]"));
        out.println(Arrays.toString(arr2).equals("[1, 2, 2, 3, 3]"));   // arr2 unchanged!
        out.println(Arrays.toString(removeDupl(arr3)).equals("[1, 2, 3, 4, 5]"));
        out.println(Arrays.toString(removeDupl(arr4)).equals("[1]"));
        out.println(Arrays.toString(removeDupl(arr5)).equals("[1]"));


        arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        // Use fact that array is sorted to search efficiently
        out.println(search(arr1, 1) == 0);
        out.println(search(arr1, 3) == 2);
        out.println(search(arr1, 8) == 7);

    }

    // -------------- Methods --------------------------
    int[] rotate(int[] arr, int rotateSteps){
        int[] rotatedArr = new int[arr.length];
        for(int index = 0; index < arr.length; index++){
            if(index+rotateSteps < arr.length){
                rotatedArr[index + rotateSteps] = arr[index];
            }else{
               int indexTemp = (index+rotateSteps)%arr.length;
                rotatedArr[indexTemp] = arr[index];
            }
        }
        return rotatedArr;
    }

    int[] rotate2(int[] arr, int rotateSteps){
        int[] rotatedArr = new int[arr.length];
        for(int index = 0; index < arr.length; index++){
            if(index+rotateSteps < arr.length){
                rotatedArr[index + rotateSteps] = arr[index];
            }else{
                int indexTemp = (index+rotateSteps)%arr.length;
                rotatedArr[indexTemp] = arr[index];
            }
        }
        return rotatedArr;
    }

    int[] removeDupl(int[] arr ){
        int[] temp = new int[arr.length];
        int realArrLength = 0;
        int realArrIndex = 0;
        for(int i = 0; i < arr.length; i++){
            if(!moreThanZeroTimes(temp, arr[i])){
                temp[realArrIndex] = arr[i];
                realArrLength++;
                realArrIndex++;
            }
        }

        int[] removedDupl = new int[realArrLength];
        for(int i = 0; i <removedDupl.length; i++){
            removedDupl[i] = temp[i];
        }

        return removedDupl;
    }

    boolean moreThanZeroTimes(int[] arr, int num){
        int times = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                times++;
            }
        }

        if(times > 0){
            return true;
        }else{
            return false;
        }
    }

    int search(int[] arr, int num){
        boolean found = false;
        int middle = arr.length/2;
        while(true){
            if(arr[middle] == num){
                return middle;
            }else if(arr[middle] > num){
                middle = middle/2;
            }else{
                middle = middle*2;
                if(middle >= arr.length){
                    middle = arr.length-1;
                }
            }
        }
    }

}

