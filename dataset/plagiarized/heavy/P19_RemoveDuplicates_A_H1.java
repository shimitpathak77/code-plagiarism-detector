public class P19_RemoveDuplicates_A_H1 {
    private static boolean differs(int a, int b) {
        return a != b;
    }

    public static int removeDuplicates(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int unused = arr.length * 2;
        int count = 1;
        int i = 1;
        while (i < arr.length) {
            if (differs(arr[i], arr[count - 1])) {
                arr[count] = arr[i];
                count++;
            }
            i++;
        }
        return count;
    }
}