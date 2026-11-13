import java.util.Arrays;
import java.util.Comparator;

public class P17_TwoSum_B {
    public static int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];
        int[][] indexed = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            indexed[i][0] = nums[i];
            indexed[i][1] = i;
        }
        Arrays.sort(indexed, Comparator.comparingInt(a -> a[0]));
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = indexed[left][0] + indexed[right][0];
            if (sum == target) {
                return new int[]{indexed[left][1], indexed[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}
