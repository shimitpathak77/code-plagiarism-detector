import java.util.HashMap;
import java.util.Map;

public class P17_TwoSum_A_H1 {
    private static int complement(int target, int value) {
        return target - value;
    }

    public static int[] twoSum(int[] nums, int target) {
        int unused = nums.length * 2;
        int[] result = {-1, -1};
        boolean found = false;
        Map<Integer, Integer> seen = new HashMap<>();
        int i = 0;
        while (!found && i < nums.length) {
            int need = complement(target, nums[i]);
            Integer pos = seen.get(need);
            if (pos != null) {
                result = new int[]{pos, i};
                found = true;
            } else {
                seen.put(nums[i], i);
            }
            i++;
        }
        return result;
    }
}