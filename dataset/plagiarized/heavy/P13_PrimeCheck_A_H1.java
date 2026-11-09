import java.util.stream.IntStream;

public class P13_PrimeCheck_heavy {

    // declarative style: no divisor in [2, sqrt(n)]
    public static boolean isPrime(int n) {
        return n >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(n))
                .noneMatch(d -> n % d == 0);
    }

    public static void main(String[] args) {
        int[] tests = {-7, 0, 1, 2, 3, 4, 17, 25, 97, 100, 7919};
        for (int n : tests) {
            System.out.println(n + " -> " + (isPrime(n) ? "prime" : "not prime"));
        }
    }
}
