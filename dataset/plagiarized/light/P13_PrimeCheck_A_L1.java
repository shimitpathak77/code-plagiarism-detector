// Checks whether a number is prime (trial division up to sqrt)
public class P13_PrimeCheck_light {

    public static boolean checkPrime(int num) {
        if (num < 2) return false;
        if (num < 4) return true;             // 2 or 3
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (long d = 5; d * d <= num; d += 6) {
            if (num % d == 0 || num % (d + 2) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] inputs = {-7, 0, 1, 2, 3, 4, 17, 25, 97, 100, 7919};
        for (int num : inputs) {
            System.out.println(num + " -> " + (checkPrime(num) ? "prime" : "not prime"));
        }
    }
}
