/*
 * <aside>
💡 **Question 2**

Given a string s containing only three types of characters: '(', ')' and '*', return true *if* s *is **valid***.

The following rules define a **valid** string:

- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
- Any right parenthesis ')' must have a corresponding left parenthesis '('.
- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

**Example 1:**

**Input:** s = "()"

**Output:**

true

</aside>
 * 
 */
package in.ineuron.gouthami;
 
import java.util.Stack;

public class ValidString {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Character> starStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == '*') {
                starStack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

        while (!stack.isEmpty() && !starStack.isEmpty()) {
            if (stack.peek() > starStack.peek()) {
                return false;
            }
            stack.pop();
            starStack.pop();
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()";
        boolean result = isValid(s);
        System.out.println("Valid String is ::"+result);
    }
}
