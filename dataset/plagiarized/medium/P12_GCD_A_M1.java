public class P12_GCD_medium {

    // recursive Euclid, sign fixed at the base case
    public static int gcd(int a, int b) {
        return (b == 0) ? Math.abs(a) : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[][] tests = {{48, 18}, {17, 5}, {0, 9}, {100, 75}, {-12, 18}};
        for (int[] t : tests) {
            System.out.println("gcd(" + t[0] + ", " + t[1] + ") = " + gcd(t[0], t[1]));
        }
    }
}
