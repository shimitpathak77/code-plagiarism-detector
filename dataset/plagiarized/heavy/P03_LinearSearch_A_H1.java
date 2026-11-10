public class P03_LinearSearch_A_H1 {

    // Recursive scan: look at one element, then recurse on the remainder
    private static int scan(int[] items, int wanted, int from) {
        if (from >= items.length) {
            return -1;
        }
        if (items[from] == wanted) {
            return from;
        }
        return scan(items, wanted, from + 1);
    }

    static int find(int[] items, int wanted) {
        return scan(items, wanted, 0);
    }

    public static void main(String[] args) {
        int[] source = {10, 25, 3, 47, 8, 19};
        for (int wanted : new int[]{47, 10, 19, 100}) {
            int result = find(source, wanted);
            System.out.println(wanted + (result == -1 ? " not found" : " found at index " + result));
        }
    }
}
