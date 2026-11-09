/**
 * P14 Anagram Check - O(n) time, O(1) space (fixed 26-slot count array).
 * Ignores case and non-letter characters (spaces, punctuation).
 */
public class P14_AnagramCheck_A_L1 {

    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        int[] count = new int[26];
        for (char c : s1.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') count[c - 'a']++;
        }
        for (char c : s2.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z') count[c - 'a']--;
        }
        for (int x : count) {
            if (x != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] tests = {
                {"listen", "silent"},
                {"Dormitory", "dirty room"},
                {"hello", "world"},
                {"abc", "abcd"},
                {"Astronomer", "Moon starer"}
        };
        for (String[] t : tests) {
            System.out.println("\"" + t[0] + "\" vs \"" + t[1] + "\" -> "
                    + (isAnagram(t[0], t[1]) ? "anagram" : "not anagram"));
        }
    }
}