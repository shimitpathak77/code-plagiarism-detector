public class P19_RemoveDuplicates_A_L1 {
    // removes repeated values from a sorted array, returns how many are left
    public static int compact(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int next = 1;
        for (int cur = 1; cur < data.length; cur++) {
            if (data[cur] != data[next - 1]) {
                data[next] = data[cur];
                next++;
            }
        }
        return next;
    }
}
