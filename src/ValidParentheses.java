import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/valid-parentheses/submissions/1421495119
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([])"));
        System.out.println(isValid("["));
    }

    /**
     * Determines, whether the input string contains valid parentheses sequence.
     *
     * @param s Input string.
     * @return Whether the input string is valid.
     */
    public static boolean isValid(String s) {
        int length = s.length();
        if (length == 0 || length % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> characters = new HashMap<>(Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        ));
        Deque<Character> open = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters.containsKey(c)) {
                open.add(c);
            } else {
                if (open.isEmpty() || characters.get(open.peekLast()) != c) {
                    return false;
                } else {
                    open.pollLast();
                }
            }
        }
        return open.isEmpty();
    };
}