public class P03_LinearSearch_A {

    // Returns the index of the first occurrence of key, or -1 if not found
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {10, 25, 3, 47, 8, 19};
        int[] keys = {47, 10, 19, 100};
        for (int key : keys) {
            int idx = linearSearch(arr, key);
            if (idx >= 0) {
                System.out.println(key + " found at index " + idx);
            } else {
                System.out.println(key + " not found");
            }
        }
    }
}
