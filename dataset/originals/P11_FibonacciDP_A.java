/** P11 Fibonacci using Dynamic Programming */
public class P11_FibonacciDP {

    // Bottom-up with dp table - O(n) time, O(n) space
    public static long fibonacciTable(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return n;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Bottom-up, space optimised - O(n) time, O(1) space
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    public static void main(String[] args) {
        for (int n : new int[]{0, 1, 2, 5, 10, 20, 50}) {
            System.out.println("fib(" + n + ") = " + fibonacci(n)
                    + "   (table: " + fibonacciTable(n) + ")");
        }
    }
}