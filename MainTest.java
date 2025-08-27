import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import java.util.*;

public class MainTest {

    // Helper to generate permutations as a list (instead of printing)
    private ArrayList<ArrayList<Integer>> getPermutations(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
            for (int i = 1; i < n + 1; i++) {
                arr.add(i);
            }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Main.collectPermutations(0, arr, result);
        return result;
    }

    @Test
    public void testN1() {
        ArrayList<ArrayList<Integer>> result = getPermutations(1);
        assertEquals(1, result.size());  // only the empty permutation
        assertTrue(result.contains(Arrays.asList(1)));
    }

    @Test
    public void testN3() {
        ArrayList<ArrayList<Integer>> result = getPermutations(3);
        assertEquals(6, result.size());  // 3! = 6
        assertTrue(result.contains(Arrays.asList(1,2,3)));
    }

    @Test
    public void testN10() {
        ArrayList<ArrayList<Integer>> result = getPermutations(10);
        assertEquals(3628800, result.size());  // 10! = 3,628,800
    }
}