public class P04_PalindromeString_A {

    // Ignores case and non-alphanumeric characters
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] tests = {"madam", "Racecar", "A man, a plan, a canal: Panama", "hello", ""};
        for (String t : tests) {
            System.out.println("\"" + t + "\" -> " + (isPalindrome(t) ? "Palindrome" : "Not a palindrome"));
        }
    }
}
