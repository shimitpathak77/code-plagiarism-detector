public class P06_Factorial_A_M1 {

    static long compute(int number) {
        if (number > 20) {
            throw new IllegalArgumentException("n > 20 overflows long");
        }
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        long answer = 1;
        int counter = number;
        while (counter > 1) {
            answer = answer * counter;
            counter--;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] inputs = {0, 1, 5, 10, 20};
        for (int i = 0; i < inputs.length; i++) {
            System.out.println(inputs[i] + "! = " + compute(inputs[i]));
        }
    }
}
