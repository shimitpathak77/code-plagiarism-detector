// Anagram test using letter frequency counts (case and non-letters ignored)
public class P14_AnagramCheck_light {

    public static boolean areAnagrams(String first, String second) {
        if (first == null || second == null) return false;
        int[] freq = new int[26];
        for (char ch : first.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') freq[ch - 'a']++;
        }
        for (char ch : second.toLowerCase().toCharArray()) {
            if (ch >= 'a' && ch <= 'z') freq[ch - 'a']--;
        }
        for (int f : freq) {
            if (f != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {
                {"listen", "silent"},
                {"Dormitory", "dirty room"},
                {"hello", "world"},
                {"abc", "abcd"},
                {"Astronomer", "Moon starer"}
        };
        for (String[] p : pairs) {
            System.out.println("\"" + p[0] + "\" vs \"" + p[1] + "\" -> "
                    + (areAnagrams(p[0], p[1]) ? "anagram" : "not anagram"));
        }
    }
}
