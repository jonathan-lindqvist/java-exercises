package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/*
 * Permutations of strings
 *
 * This is meant to use recursion. See
 * https://introcs.cs.princeton.edu/java/23recursion/
 * https://en.wikipedia.org/wiki/Recursion_(computer_science)
 *
 * See:
 * - UseString
 * - UseAList
 */
public class Ex7Permutations {

    public static void main(String[] args) {
        new Ex7Permutations().program();
    }

    void program() {
        List<String> ps = Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba");
        List<String> perms = perm("abc");

        // Some checks
        out.println(perms.size() == 6);
        out.println(perms.containsAll(ps));
        out.println(!perms.contains("aab"));
        out.println(!perms.contains("abb"));

    }

    // -------- Methods -----------
    // TODO
    List<String> perm(String str){
        List<String> allPerms = new ArrayList<>();
        char[] arr = str.toCharArray();
        getPerms(arr,);
        return allPerms;
    }

    void getPerms(char[] a, int n) {
        if (n == 1) {
            out.println(new String(a));
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n-1);
            getPerms(a, n-1);
            swap(a, i, n-1);
        }
    }

    void swap(char[] a, int i, int j) {
        char c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

}
