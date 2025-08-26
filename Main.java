import java.util.ArrayList;
import java.util.List;

public class Main { 
    // Owen and Haider's lab
    public static void main(String[] args) {

        // takes an integer, and creates a string of the natural numbers from 1 to n
        // to run, pick your size, set n to that
        int n = 3;
        ArrayList<Integer> Arr = new ArrayList<Integer>();
        for (int i = 1; i < n + 1; i++) {
            Arr.add(i);
        } 
        permuteTime(0, Arr);
    }

    // swap the ith and jth index
    static void swap(ArrayList<Integer> Arr, int i, int j) {
        int temp = Arr.get(i);
        Arr.set(i, Arr.get(j));
        Arr.set(j, temp);
    }

    // this is a recursive function that will give us the permutations
    static void recurPermute(int index, ArrayList<Integer> Arr) {

        if (Arr.isEmpty()) {
            System.err.println("String is empty ;(");
        }
        
        // the base case, when the length of the string is the same as the index,
        // it prints the string
        if (index == Arr.size()) {
            System.out.println(Arr);
        }

        // swaps current index with all possible indices, then recur
        for (int i = index; i < Arr.size(); i++) {

            swap(Arr, i, index);
            recurPermute(index + 1, Arr);
            swap(Arr, i, index);
        }
    }

    // function that calls
    static void permuteTime(int index, ArrayList<Integer> Arr) {
        long t1 = System.currentTimeMillis();
        recurPermute(0, Arr);
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
    }

    // helper to collect permutations into a list for testing
    static void collectPermutations(int index, ArrayList<Integer> Arr, List<List<Integer>> result) {
    if (index == Arr.size()) {
        result.add(new ArrayList<>(Arr));
        return;
    }
    for (int i = index; i < Arr.size(); i++) {
        swap(Arr, i, index);
        collectPermutations(index + 1, Arr, result);
        swap(Arr, i, index);
    }
}
}