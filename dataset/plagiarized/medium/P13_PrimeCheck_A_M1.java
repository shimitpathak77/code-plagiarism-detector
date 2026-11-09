public class P13_PrimeCheck_medium {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0) return false;
        int d = 3;
        while ((long) d * d <= n) {
            if (n % d == 0) {
                return false;
            }
            d += 2;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] tests = {-7, 0, 1, 2, 3, 4, 17, 25, 97, 100, 7919};
        for (int n : tests) {
            System.out.println(n + " -> " + (isPrime(n) ? "prime" : "not prime"));
        }
    }
}
