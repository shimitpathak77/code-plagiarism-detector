// Fibonacci numbers computed with dynamic programming
public class P11_FibonacciDP_light {

    // dp array version
    public static long fibWithArray(int num) {
        if (num < 0) throw new IllegalArgumentException("n must be >= 0");
        if (num <= 1) return num;
        long[] memo = new long[num + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int k = 2; k <= num; k++) {
            memo[k] = memo[k - 1] + memo[k - 2];
        }
        return memo[num];
    }

    // two-variable version
    public static long fibWithVars(int num) {
        if (num < 0) throw new IllegalArgumentException("n must be >= 0");
        if (num <= 1) return num;
        long older = 0, newer = 1;
        for (int k = 2; k <= num; k++) {
            long sum = older + newer;
            older = newer;
            newer = sum;
        }
        return newer;
    }

    public static void main(String[] args) {
        for (int num : new int[]{0, 1, 2, 5, 10, 20, 50}) {
            System.out.println("fib(" + num + ") = " + fibWithVars(num)
                    + "   (table: " + fibWithArray(num) + ")");
        }
    }
}
