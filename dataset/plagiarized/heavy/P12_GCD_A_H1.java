public class P12_GCD_heavy {

    // binary GCD (Stein's algorithm): only shifts and subtraction
    public static int gcd(int a, int b) {
        long x = Math.abs((long) a);
        long y = Math.abs((long) b);
        if (x == 0) return (int) y;
        if (y == 0) return (int) x;
        int shift = Long.numberOfTrailingZeros(x | y);
        x >>= Long.numberOfTrailingZeros(x);
        while (y != 0) {
            y >>= Long.numberOfTrailingZeros(y);
            if (x > y) {
                long t = x;
                x = y;
                y = t;
            }
            y -= x;
        }
        return (int) (x << shift);
    }

    public static void main(String[] args) {
        int[][] tests = {{48, 18}, {17, 5}, {0, 9}, {100, 75}, {-12, 18}};
        for (int[] t : tests) {
            System.out.println("gcd(" + t[0] + ", " + t[1] + ") = " + gcd(t[0], t[1]));
        }
    }
}
