public class P05_CountVowels_A {

    // Counts vowels (a, e, i, o, u) case-insensitively
    public static int countVowels(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u' -> count++;
                default -> { }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] tests = {"Hello World", "Java Programming", "rhythm", "AEIOU aeiou"};
        for (String t : tests) {
            System.out.println("\"" + t + "\" -> " + countVowels(t) + " vowel(s)");
        }
    }
}
