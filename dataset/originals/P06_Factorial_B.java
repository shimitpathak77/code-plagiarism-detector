public class P06_Factorial_B {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("Negative numbers not allowed");
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
