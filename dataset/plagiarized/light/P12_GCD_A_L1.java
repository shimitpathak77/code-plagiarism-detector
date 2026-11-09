// Greatest common divisor via Euclid's method
public class P12_GCD_light {

    public static int findGcd(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        while (y != 0) {
            int rem = x % y;
            x = y;
            y = rem;
        }
        return x;
    }

    public static void main(String[] args) {
        int[][] cases = {{48, 18}, {17, 5}, {0, 9}, {100, 75}, {-12, 18}};
        for (int[] c : cases) {
            System.out.println("gcd(" + c[0] + ", " + c[1] + ") = " + findGcd(c[0], c[1]));
        }
    }
}
