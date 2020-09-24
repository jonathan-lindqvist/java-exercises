package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/*
   Using Steinhaus-Johnson-Trotter (non-recursive) algorithm for permutations
   See https://en.wikipedia.org/wiki/Steinhaus%E2%80%93Johnson%E2%80%93Trotter_algorithm

   See:
   - UseString
   - UseAList
 */
public class Ex6SJT {

    public static void main(String[] args) {
        new Ex6SJT().program();
    }

    private void program() {
        // Call permutation method
        List<String> perms = permutationSJT("123456");

        out.println(perms.size() == 720);  // 720
        for (String s : perms) {
            out.println(s);
        }

        int count = 0;
        for (String s : perms) {
            if (s.equals("123456")) {
                count++;
            }
        }
        out.println(count == 1);
    }

    // Steinhaus–Johnson–Trotter permutation algorithm iterative!
    // Use functional decomposition!
    // TODO
    List<String> permutationSJT(String s) {
        List<String> permutations = new ArrayList<>();
        String[] arr = s.split("");
        // false is left, true is right.
        boolean[] dir = new boolean[arr.length];

        // Add first permutation.
        permutations.add(s);
        while(gotMobiles(arr,dir)){
            // Find greatest mobile value and move
            // move until it can not move
            // find next greatest mobile value
            // then invert dir for all values that are greater than the current largest mobile value

            int indexLargestMobile = getIndexOfLargestMobile(arr, dir);
            //out.println(indexLargestMobile);
            int swapIndex = dir[indexLargestMobile] ? indexLargestMobile + 1 : indexLargestMobile -1;
            out.println(Arrays.toString(arr));
            swap(arr, indexLargestMobile, swapIndex);
            swap(dir, indexLargestMobile, swapIndex);

            /*

            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                // this part is executed when an exception (in this example InterruptedException) occurs
            }
             */

        }

        return permutations;
    }

    boolean gotMobiles(String[] arr, boolean[] dir){
        boolean anyMobile = false;

        /*
        To be mobile it needs to be greater than the value it is pointing to.
         */

        for(int i = 0; i < arr.length; i++){
            boolean dirForIndex = dir[i];
            if((dir[i] && i + 1 < arr.length) || (!dir[i] && i - 1 >= 0)){
                int neighbourIndex = (dirForIndex) ? i+1 : i-1;
                String neighbourValue = arr[neighbourIndex];
                if(Integer.parseInt(arr[i]) > Integer.parseInt(neighbourValue)){
                    anyMobile = true;
                    break;
                }
            }

        }

        return anyMobile;
    }

    int getIndexOfLargestMobile(String[] arr, boolean[] dir){
        int indexLargest = 0;
        int largestValue = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            boolean dirForIndex = dir[i];
            if((dir[i] && i + 1 < arr.length) || (!dir[i] && i - 1 >= 0)){
                int neighbourIndex = (dirForIndex) ? i+1 : i-1;
                String neighbourValue = arr[neighbourIndex];
                if(Integer.parseInt(arr[i]) > Integer.parseInt(neighbourValue)){
                    if(Integer.parseInt(arr[i]) > largestValue){
                        indexLargest = i;
                    }
                }
            }

        }
        return indexLargest;
    }

    void swap(String[] arr, int i1, int i2) {
        String temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    void swap(boolean[] arr, int i1, int i2) {
        boolean temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}