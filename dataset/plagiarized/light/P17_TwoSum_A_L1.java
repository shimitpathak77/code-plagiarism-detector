import java.util.HashMap;
import java.util.Map;

public class P17_TwoSum_A_L1 {
    // looks for two positions whose values add up to the goal
    public static int[] findPair(int[] values, int goal) {
        Map<Integer, Integer> lookup = new HashMap<>();
        for (int idx = 0; idx < values.length; idx++) {
            int rest = goal - values[idx];
            if (lookup.containsKey(rest)) { return new int[]{lookup.get(rest), idx}; }
            lookup.put(values[idx], idx);
        }
        return new int[]{-1, -1};
    }
}