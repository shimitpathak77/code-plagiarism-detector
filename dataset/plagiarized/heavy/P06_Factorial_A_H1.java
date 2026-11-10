public class P06_Factorial_A_H1 {

    // Recursive definition: n! = n * (n-1)!
    private static long recurse(int n) {
        return (n <= 1) ? 1L : n * recurse(n - 1);
    }

    static long fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20) {
            throw new IllegalArgumentException("n > 20 overflows long");
        }
        return recurse(n);
    }

    public static void main(String[] args) {
        for (int n : new int[]{0, 1, 5, 10, 20}) {
            System.out.println(n + "! = " + fact(n));
        }
    }
}
