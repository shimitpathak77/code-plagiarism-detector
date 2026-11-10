public class P06_Factorial_A {

    // Iterative factorial; long holds values up to 20!
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("n > 20 overflows long");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] tests = {0, 1, 5, 10, 20};
        for (int n : tests) {
            System.out.println(n + "! = " + factorial(n));
        }
    }
}
