/* Sequential (linear) search demo */
public class P03_LinearSearch_A_L1 {

    // index of first match, otherwise -1
    public static int linearSearch(int[] arr, int key)
    {
        for (int idx = 0; idx < arr.length; idx++)
        {
            if (arr[idx] == key)
            {
                return idx;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        int[] arr = {10, 25, 3, 47, 8, 19};
        int[] keys = {47, 10, 19, 100};
        for (int key : keys)
        {
            int idx = linearSearch(arr, key);
            if (idx >= 0)
            {
                System.out.println(key + " found at index " + idx);
            }
            else
            {
                System.out.println(key + " not found");
            }
        }
    }
}
