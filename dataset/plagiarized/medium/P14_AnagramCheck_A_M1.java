import java.util.Arrays;

public class P14_AnagramCheck_medium {

    private static int[] letterCounts(String s) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if (Character.isLetter(c) && c <= 'z') {
                counts[c - 'a']++;
            }
        }
        return counts;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        return Arrays.equals(letterCounts(s1), letterCounts(s2));
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
