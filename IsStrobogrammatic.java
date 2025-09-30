import java.util.HashMap;
import java.util.Map;

public class IsStrobogrammatic {
    public static boolean isStrobogrammatic(String num) {
       Map<Character, Character> map = new HashMap<>();
       map.put('0', '0');
       map.put('1', '1');
       map.put('8', '8');
       map.put('6', '9');
       map.put('9', '6');
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            if (!map.containsKey(leftChar) || map.get(leftChar) != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrobogrammatic("69"));   // true
        System.out.println(isStrobogrammatic("88"));   // true
        System.out.println(isStrobogrammatic("101"));  // false
    }
}