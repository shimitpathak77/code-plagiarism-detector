/** P12 GCD using the Euclidean algorithm - O(log(min(a, b))) */
public class P12_GCD {

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] tests = {{48, 18}, {17, 5}, {0, 9}, {100, 75}, {-12, 18}};
        for (int[] t : tests) {
            System.out.println("gcd(" + t[0] + ", " + t[1] + ") = " + gcd(t[0], t[1]));
        }
    }
}