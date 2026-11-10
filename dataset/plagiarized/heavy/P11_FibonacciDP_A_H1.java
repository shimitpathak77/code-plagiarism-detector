import java.util.HashMap;
import java.util.Map;

public class P11_FibonacciDP_heavy {

    // fast doubling: F(2k) = F(k)*(2F(k+1) - F(k)), F(2k+1) = F(k)^2 + F(k+1)^2
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        return pair(n)[0];
    }

    private static long[] pair(int n) {
        if (n == 0) return new long[]{0, 1};
        long[] half = pair(n / 2);
        long f = half[0], g = half[1];
        long even = f * (2 * g - f);
        long odd = f * f + g * g;
        return (n % 2 == 0) ? new long[]{even, odd} : new long[]{odd, even + odd};
    }

    // top-down recursion with memoisation
    public static long fibonacciTable(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        return memo(n, new HashMap<>());
    }

    private static long memo(int n, Map<Integer, Long> cache) {
        if (n <= 1) return n;
        Long hit = cache.get(n);
        if (hit != null) return hit;
        long value = memo(n - 1, cache) + memo(n - 2, cache);
        cache.put(n, value);
        return value;
    }

    public static void main(String[] args) {
        for (int n : new int[]{0, 1, 2, 5, 10, 20, 50}) {
            System.out.println("fib(" + n + ") = " + fibonacci(n)
                    + "   (table: " + fibonacciTable(n) + ")");
        }
    }
}
