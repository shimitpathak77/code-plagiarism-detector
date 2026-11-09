/* Count how many vowels a string contains */
public class P05_CountVowels_A_L1 {

    // vowels: a e i o u (any case)
    public static int countVowels(String str)
    {
        int total = 0;
        for (char ch : str.toLowerCase().toCharArray())
        {
            switch (ch)
            {
                case 'a', 'e', 'i', 'o', 'u' -> total++;
                default -> { }
            }
        }
        return total;
    }

    public static void main(String[] args)
    {
        String[] tests = {"Hello World", "Java Programming", "rhythm", "AEIOU aeiou"};
        for (String t : tests)
        {
            System.out.println("\"" + t + "\" -> " + countVowels(t) + " vowel(s)");
        }
    }
}
