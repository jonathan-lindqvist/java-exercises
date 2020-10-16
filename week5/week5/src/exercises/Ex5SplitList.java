package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.out;

/*
 * Partition a List into a number of sub lists with as equal length as possible
 *
 * NOTE: References may be shared
 */
public class Ex5SplitList {

    public static void main(String[] args) {
        new Ex5SplitList().program();
    }

    void program() {
        // Will get an immutable list
        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        List<List<Integer>> ps = partition(ints, 2);
        out.println(ps.get(0).toString().equals("[1, 2]"));
        out.println(ps.get(1).toString().equals("[3, 4]"));

        ps = partition(ints, 4);
        out.println(ps.get(0).toString().equals("[1]"));
        out.println(ps.get(1).toString().equals("[2]"));
        out.println(ps.get(2).toString().equals("[3]"));
        out.println(ps.get(3).toString().equals("[4]"));

        //ps = partition(null, 3); // Exception, list null or empty
        //ps = partition(ints, 5); // Exception, list too short (n > list.size())
        //ps = partition(ints, 0); // Exception, n must be positive

        ints = Arrays.asList(1, 2, 3, 4, 5);
        ps = partition(ints, 2);
        out.println(ps.get(0).toString().equals("[1, 2]"));
        out.println(ps.get(1).toString().equals("[3, 4, 5]"));

        ps = partition(ints, 3);
        out.println(ps.get(0).toString().equals("[1]"));
        out.println(ps.get(1).toString().equals("[2, 3]"));
        out.println(ps.get(2).toString().equals("[4, 5]"));

        ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        ps = partition(ints, 3);
        out.println(ps.get(0).toString().equals("[1, 2]"));
        out.println(ps.get(1).toString().equals("[3, 4]"));
        out.println(ps.get(2).toString().equals("[5, 6, 7]"));

    }

    // --------- Methods -----------------------

    private List<List<Integer>> partition(List<Integer> list, int numOfLists){
        List<Integer> newList = new ArrayList<>(list);
        List<List<Integer>> partitionList = new ArrayList<>();
        double times = Math.floor(list.size()/numOfLists);

        while(!newList.isEmpty()){
            if(times > newList.size()){
                int lastListIndex = partitionList.size() - 1;
                for(Integer i : newList){
                    partitionList.get(lastListIndex).add(i);
                }
                newList.clear();
            }else{
                List<Integer> tempList = new ArrayList<>();
                for(int i = 0; i < times;i++){
                    tempList.add(newList.get(i));
                }

                times = Math.round(list.size() / (double)numOfLists); // hacky solution to get the smaller list in the beginning and bigger later
                partitionList.add(tempList);
                newList.removeAll(tempList);
            }
        }

        return partitionList;
    }
}
