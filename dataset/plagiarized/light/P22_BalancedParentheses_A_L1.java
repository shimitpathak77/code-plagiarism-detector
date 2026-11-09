public class P22_BalancedParentheses_A_L1 {
    // checks that every bracket has a matching partner in the right order
    public static boolean checkBrackets(String text) {
        char[] holder = new char[text.length()];
        int pos = -1;

        for (int idx = 0; idx < text.length(); idx++) {
            char ch = text.charAt(idx);
            if (ch == '(' || ch == '{' || ch == '[') {
                holder[++pos] = ch;
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (pos == -1) {
                    return false;
                }
                char last = holder[pos--];
                if (!pair(last, ch)) {
                    return false;
                }
            }
        }
        return pos == -1;
    }

    private static boolean pair(char left, char right) {
        return (left == '(' && right == ')')
                || (left == '{' && right == '}')
                || (left == '[' && right == ']');
    }
}