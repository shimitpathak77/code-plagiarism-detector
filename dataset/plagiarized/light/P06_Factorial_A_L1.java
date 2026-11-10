/* Factorial calculator (iterative) */
public class P06_Factorial_A_L1 {

    // long can store up to 20!
    public static long factorial(int n)
    {
        if (n < 0)
        {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n > 20)
        {
            throw new IllegalArgumentException("n > 20 overflows long");
        }
        long product = 1;
        for (int k = 2; k <= n; k++)
        {
            product *= k;
        }
        return product;
    }

    public static void main(String[] args)
    {
        int[] tests = {0, 1, 5, 10, 20};
        for (int n : tests)
        {
            System.out.println(n + "! = " + factorial(n));
        }
    }
}
