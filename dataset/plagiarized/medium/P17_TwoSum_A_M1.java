import java.util.HashMap;

public class P17_TwoSum_A_M1 {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> index = new HashMap<>();
        int i = 0;
        for (; i < nums.length; i++) {
            int other = target - nums[i];
            Integer j = index.get(other);
            if (j != null) {
                return new int[]{j, i};
            }
            index.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
