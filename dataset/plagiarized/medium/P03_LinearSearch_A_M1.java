public class P03_LinearSearch_A_M1 {

    static int locate(int[] data, int target) {
        int position = -1;
        int n = 0;
        while (n < data.length && position == -1) {
            if (data[n] == target) {
                position = n;
            }
            n++;
        }
        return position;
    }

    public static void main(String[] args) {
        int[] list = {10, 25, 3, 47, 8, 19};
        int[] queries = {47, 10, 19, 100};
        for (int q : queries) {
            int where = locate(list, q);
            String message = (where >= 0) ? q + " found at index " + where : q + " not found";
            System.out.println(message);
        }
    }
}
