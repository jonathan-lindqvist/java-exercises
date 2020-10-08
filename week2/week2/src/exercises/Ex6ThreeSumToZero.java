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

    int[] getThreeSum(int[] arr) {

        // fix code later, this works
        boolean found = false;

        // sort array elements
        Arrays.sort(arr);

        for (int i=0; i<n-1; i++)
        {
            // initialize left and right
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r)
            {
                if (x + arr[l] + arr[r] == 0)
                {
                    // print elements if it's sum is zero
                    System.out.print(x + " ");
                    System.out.print(arr[l]+ " ");
                    System.out.println(arr[r]+ " ");

                    l++;
                    r--;
                    found = true;
                }

                // If sum of three elements is less
                // than zero then increment in left
                else if (x + arr[l] + arr[r] < 0)
                    l++;

                    // if sum is greater than zero than
                    // decrement in right side
                else
                    r--;
            }
        }

        if (found == false)
            System.out.println(" No Triplet Found");
    }

    // Driven source
    public static void main (String[] args) {

        int arr[] = {0, -1, 2, -3, 1};
        int n =arr.length;
        findTriplets(arr, n);
    }
//This code is contributed by Tushil..
    }


}
