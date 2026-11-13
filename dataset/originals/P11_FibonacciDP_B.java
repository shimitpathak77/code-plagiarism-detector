public class P11_FibonacciDP_B {
    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        long prev2 = 0;
        long prev1 = 1;
        for (int i = 2; i <= n; i++) {
            long current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }
}
