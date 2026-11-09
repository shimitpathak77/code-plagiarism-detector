public class P19_RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int write = 1;
        for (int read = 1; read < arr.length; read++) {
            if (arr[read] != arr[write - 1]) {
                arr[write] = arr[read];
                write++;
            }
        }
        return write;
    }
}
