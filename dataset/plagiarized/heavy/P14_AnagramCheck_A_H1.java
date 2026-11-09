import java.util.Arrays;

public class P14_AnagramCheck_heavy {

    // keep only letters, lower-case them, sort, and compare the sorted forms
    private static char[] normalised(String s) {
        char[] letters = s.toLowerCase().replaceAll("[^a-z]", "").toCharArray();
        Arrays.sort(letters);
        return letters;
    }

    public static boolean isAnagram(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
        return Arrays.equals(normalised(s1), normalised(s2));
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
