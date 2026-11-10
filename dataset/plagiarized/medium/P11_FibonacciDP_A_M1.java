public class P11_FibonacciDP_medium {

    private static void validate(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
    }

    // rolling pair, loop runs n times
    public static long fibonacci(int n) {
        validate(n);
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            long t = a + b;
            a = b;
            b = t;
        }
        return a;
    }

    // table filled with a while loop
    public static long fibonacciTable(int n) {
        validate(n);
        long[] table = new long[Math.max(2, n + 1)];
        table[1] = 1;
        int i = 2;
        while (i <= n) {
            table[i] = table[i - 2] + table[i - 1];
            i++;
        }
        return table[n];
    }

    public static void main(String[] args) {
        for (int n : new int[]{0, 1, 2, 5, 10, 20, 50}) {
            System.out.println("fib(" + n + ") = " + fibonacci(n)
                    + "   (table: " + fibonacciTable(n) + ")");
        }
    }
}
