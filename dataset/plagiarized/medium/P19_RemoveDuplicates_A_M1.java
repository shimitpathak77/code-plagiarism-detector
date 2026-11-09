public class P19_RemoveDuplicates_A_M1 {
    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int write = 0;
        for (int read = 1; read < arr.length; read++) {
            if (arr[read] != arr[write]) {
                write++;
                arr[write] = arr[read];
            }
        }
        return write + 1;
    }
}