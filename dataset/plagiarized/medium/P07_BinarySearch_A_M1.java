public class P07_BinarySearch_A_M1 {

    static int bsearch(int[] values, int target) {
        int begin = 0;
        int finish = values.length - 1;
        while (begin <= finish) {
            int center = (begin + finish) >>> 1;
            int cmp = Integer.compare(values[center], target);
            if (cmp == 0) {
                return center;
            }
            if (cmp > 0) {
                finish = center - 1;
            } else {
                begin = center + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] data = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int[] wanted = {23, 2, 91, 7};
        for (int w : wanted) {
            int at = bsearch(data, w);
            System.out.println(w + (at >= 0 ? " found at index " + at : " not found"));
        }
    }
}
