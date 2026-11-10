import java.util.Set;

public class P05_CountVowels_A_H1 {

    private static final Set<Integer> VOWEL_CODES = Set.of((int) 'a', (int) 'e', (int) 'i', (int) 'o', (int) 'u');

    // Stream pipeline: lower-case, keep vowel code points, count them
    static int howManyVowels(String sentence) {
        return (int) sentence.toLowerCase()
                .chars()
                .filter(VOWEL_CODES::contains)
                .count();
    }

    public static void main(String[] args) {
        java.util.List.of("Hello World", "Java Programming", "rhythm", "AEIOU aeiou")
                .forEach(s -> System.out.println("\"" + s + "\" -> " + howManyVowels(s) + " vowel(s)"));
    }
}
