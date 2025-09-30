import java.util.Stack;

public class isBalanced {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } 
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || !isMatchingPair(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    }

    // Main method for testing
    public static void main(String[] args) {
        String test1 = "()[]{}";
        String test2 = "(]";
        String test3 = "([{}])";
        String test4 = "([)]";

        System.out.println(isValid(test1)); // true
        System.out.println(isValid(test2)); // false
        System.out.println(isValid(test3)); // true
        System.out.println(isValid(test4)); // false
    }
}


