import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.*;

public class MainTest {

    // Helper to generate permutations as a list (instead of printing)
    private List<List<Integer>> getPermutations(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) arr.add(i);

        List<List<Integer>> result = new ArrayList<>();
        Main.collectPermutations(0, arr, result);
        return result;
    }

    @Test
    public void testN0() {
        List<List<Integer>> result = getPermutations(0);
        assertEquals(1, result.size());  // only the empty permutation
        assertTrue(result.contains(Collections.emptyList()));
    }

    @Test
    public void testN3() {
        List<List<Integer>> result = getPermutations(3);
        assertEquals(6, result.size());  // 3! = 6
        assertTrue(result.contains(Arrays.asList(1,2,3)));
    }

    @Test
    public void testN10() {
        List<List<Integer>> result = getPermutations(10);
        assertEquals(3628800, result.size());  // 10! = 3,628,800
    }
}