public class P09_SelectionSort_B {
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIdx = 0;
            for (int j = 1; j <= i; j++) {
                if (arr[j] > arr[maxIdx]) {
                    maxIdx = j;
                }
            }
            if (maxIdx != i) {
                int temp = arr[i];
                arr[i] = arr[maxIdx];
                arr[maxIdx] = temp;
            }
        }
    }
}
