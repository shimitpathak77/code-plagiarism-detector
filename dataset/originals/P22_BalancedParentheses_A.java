public class P22_BalancedParentheses {
    public static boolean isBalanced(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else if (c == ')' || c == '}' || c == ']') {
                if (top == -1) {
                    return false;
                }
                char open = stack[top--];
                if (!matches(open, c)) {
                    return false;
                }
            }
        }
        return top == -1;
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}