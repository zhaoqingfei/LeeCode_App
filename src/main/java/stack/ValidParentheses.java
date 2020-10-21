package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20.有效的括号
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    public boolean isValidB(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (Character ch : s.toCharArray()) {
            if (ch =='(') {
                stack.push(')');
            } else if (ch =='[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || ch != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }


}
