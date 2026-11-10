public class P04_PalindromeString_A_M1 {

    static boolean check(String text) {
        int lo = 0;
        int hi = text.length() - 1;
        while (lo < hi) {
            char a = text.charAt(lo);
            char b = text.charAt(hi);
            if (!Character.isLetterOrDigit(a)) {
                lo++;
            } else if (!Character.isLetterOrDigit(b)) {
                hi--;
            } else if (Character.toLowerCase(a) != Character.toLowerCase(b)) {
                return false;
            } else {
                lo++;
                hi--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] samples = {"madam", "Racecar", "A man, a plan, a canal: Panama", "hello", ""};
        for (int i = 0; i < samples.length; i++) {
            String verdict = check(samples[i]) ? "Palindrome" : "Not a palindrome";
            System.out.println("\"" + samples[i] + "\" -> " + verdict);
        }
    }
}
