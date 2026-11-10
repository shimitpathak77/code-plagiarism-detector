/* Check whether a string reads the same forwards and backwards */
public class P04_PalindromeString_A_L1 {

    // case and punctuation are ignored
    public static boolean isPalindrome(String str)
    {
        int start = 0, end = str.length() - 1;
        while (start < end)
        {
            while (start < end && !Character.isLetterOrDigit(str.charAt(start))) start++;
            while (start < end && !Character.isLetterOrDigit(str.charAt(end))) end--;
            if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end)))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args)
    {
        String[] tests = {"madam", "Racecar", "A man, a plan, a canal: Panama", "hello", ""};
        for (String t : tests)
        {
            System.out.println("\"" + t + "\" -> " + (isPalindrome(t) ? "Palindrome" : "Not a palindrome"));
        }
    }
}
