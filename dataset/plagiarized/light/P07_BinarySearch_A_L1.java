/* Binary search on a sorted array (iterative) */
public class P07_BinarySearch_A_L1 {

    // returns index of key or -1
    public static int binarySearch(int[] arr, int key)
    {
        int left = 0, right = arr.length - 1;
        while (left <= right)
        {
            int middle = left + (right - left) / 2;   // safe midpoint
            if (arr[middle] == key)
            {
                return middle;
            }
            else if (arr[middle] < key)
            {
                left = middle + 1;
            }
            else
            {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int[] keys = {23, 2, 91, 7};
        for (int key : keys)
        {
            int idx = binarySearch(sorted, key);
            System.out.println(key + (idx >= 0 ? " found at index " + idx : " not found"));
        }
    }
}
