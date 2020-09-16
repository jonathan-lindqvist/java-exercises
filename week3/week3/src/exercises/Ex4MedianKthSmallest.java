package exercises;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Even more array methods, possibly even harder ...
 */
public class Ex4MedianKthSmallest {

    public static void main(String[] args) {
        new Ex4MedianKthSmallest().program();
    }

    void program() {
        int[] arr1 = {9, 3, 0, 1, 3, -2};

        out.println(!isSorted(arr1));  // Is sorted increasing? No not yet!

        sort(arr1);     // Sort in increasing order original order lost!

        out.println(Arrays.toString(arr1).equals("[-2, 0, 1, 3, 3, 9]"));

        out.println(isSorted(arr1));  // Is sorted increasing? Yes!

        int[] arr2 = {5, 4, 2, 1, 7, 0, -1, -4, 12};
        int[] arr3 = {2, 3, 0, 1};
        out.println(median(arr2) == 2);    // Calculate median of elements
        out.println(median(arr3) == 1.5);

        int[] arr4 = {2, 3, 0, 1, 5, 4};
        int[] arr5 = {5, 4, 2, 2, 1, 7, 4, 0, -1, -4, 0, 0, 12};
        out.println(kSmallest(arr4, 2) == 1);   // Second smallest is 1
        out.println(kSmallest(arr5, 5) == 2);   // 5th smallest is 2

    }

    // ---------- Write methods here --------------
    boolean isSorted(int[] arr){
        boolean sorted = true;
        for(int i = 0; i < arr.length-1; i++){
            if (arr[i] > arr[i + 1]) {
                sorted = false;
                break;
            }
        }
        return sorted;
    }

    void sort(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            for(int j = 0; j < arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    double median(int[] arr){
        sort(arr);
        double medianOfArr;
        if (arr.length % 2 == 0){
            medianOfArr = ((double)arr[arr.length/2] + (double)arr[arr.length/2 - 1])/2;
        }else{
            medianOfArr = (double) arr[arr.length/2];
        }
        return medianOfArr;
    }

    int kSmallest(int[] arr, int nSmallest){
        sort(arr);
        int[] finalArr = removeDupl(arr);
        return finalArr[nSmallest-1];
    }

    int[] removeDupl(int[] arr ){
        int[] temp = new int[arr.length];
        for(int i=0;i<temp.length;i++){
            temp[i] = -100000000;
        }

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
}
