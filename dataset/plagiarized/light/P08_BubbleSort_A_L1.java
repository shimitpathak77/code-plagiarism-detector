import java.util.Arrays;

/* Bubble sort with early termination */
public class P08_BubbleSort_A_L1 {

    public static void bubbleSort(int[] arr)
    {
        int len = arr.length;
        for (int pass = 0; pass < len - 1; pass++)
        {
            boolean didSwap = false;
            for (int k = 0; k < len - 1 - pass; k++)
            {
                if (arr[k] > arr[k + 1])
                {
                    int t = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = t;
                    didSwap = true;
                }
            }
            if (!didSwap) break;   // already sorted
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Before: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After : " + Arrays.toString(arr));
    }
}
