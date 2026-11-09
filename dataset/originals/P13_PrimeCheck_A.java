/** P13 Prime Check - O(sqrt(n)) */
public class P13_PrimeCheck_A_L1 {

    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n < 4) return true;               // 2 and 3
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
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