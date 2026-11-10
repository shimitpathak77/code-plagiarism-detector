public class P05_CountVowels_A_M1 {

    private static final String VOWELS = "aeiou";

    static int vowelTotal(String input) {
        int found = 0;
        String lower = input.toLowerCase();
        for (int pos = 0; pos < lower.length(); pos++) {
            if (VOWELS.indexOf(lower.charAt(pos)) != -1) {
                found += 1;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        String[] words = {"Hello World", "Java Programming", "rhythm", "AEIOU aeiou"};
        for (String w : words) {
            System.out.println("\"" + w + "\" -> " + vowelTotal(w) + " vowel(s)");
        }
    }
}
