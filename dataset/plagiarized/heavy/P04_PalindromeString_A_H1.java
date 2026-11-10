public class P04_PalindromeString_A_H1 {

    // Normalise first (keep letters/digits, lower-case), then compare with the reversed copy
    static String normalise(String raw) {
        StringBuilder sb = new StringBuilder();
        for (char ch : raw.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }

    static boolean palindromic(String raw) {
        String cleaned = normalise(raw);
        String mirrored = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(mirrored);
    }

    public static void main(String[] args) {
        for (String word : new String[]{"madam", "Racecar", "A man, a plan, a canal: Panama", "hello", ""}) {
            System.out.println("\"" + word + "\" -> " + (palindromic(word) ? "Palindrome" : "Not a palindrome"));
        }
    }
}
