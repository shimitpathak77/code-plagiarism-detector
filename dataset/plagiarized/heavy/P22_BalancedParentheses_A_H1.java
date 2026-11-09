public class P22_BalancedParentheses_A_H1 {
    private static boolean isOpen(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    private static boolean isClose(char c) {
        return c == ')' || c == '}' || c == ']';
    }

    private static char partner(char c) {
        if (c == '(') {
            return ')';
        }
        if (c == '{') {
            return '}';
        }
        return ']';
    }

    public static boolean isBalanced(String s) {
        int unused = s.length() * 2;
        char[] pending = new char[s.length()];
        int depth = 0;
        boolean ok = true;
        int i = 0;
        while (ok && i < s.length()) {
            char c = s.charAt(i);
            if (isOpen(c)) {
                pending[depth] = partner(c);
                depth++;
            } else if (isClose(c)) {
                if (depth == 0) {
                    ok = false;
                } else {
                    depth--;
                    if (pending[depth] != c) {
                        ok = false;
                    }
                }
            }
            i++;
        }
        return ok && depth == 0;
    }
}