public class P03_LinearSearch_B {
    public static int linearSearch(int[] arr, int key) {
        if (arr == null) return -1;
        return searchRecursive(arr, key, 0);
    }
    private static int searchRecursive(int[] arr, int key, int index) {
        if (index >= arr.length) return -1;
        if (arr[index] == key) return index;
        return searchRecursive(arr, key, index + 1);
    }
}
