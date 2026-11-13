public class P08_BubbleSort_B {
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        boolean swapped = true;
        int start = 0;
        int end = arr.length - 1;
        while (swapped) {
            swapped = false;
            for (int i = start; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i]; arr[i] = arr[i + 1]; arr[i + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
            swapped = false;
            end--;
            for (int i = end - 1; i >= start; i--) {
                if (arr[i] > arr[i + 1]) {
                    int t = arr[i]; arr[i] = arr[i + 1]; arr[i + 1] = t;
                    swapped = true;
                }
            }
            start++;
        }
    }
}
