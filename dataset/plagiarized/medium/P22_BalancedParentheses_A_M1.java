import java.util.ArrayDeque;
import java.util.Deque;

public class P22_BalancedParentheses_A_M1 {
    public static boolean isBalanced(String s) {
        Deque<Character> waiting = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    waiting.push(')');
                    break;
                case '[':
                    waiting.push(']');
                    break;
                case '{':
                    waiting.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (waiting.isEmpty() || waiting.pop() != c) {
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        return waiting.isEmpty();
    }
}
