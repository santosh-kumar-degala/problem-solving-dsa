import java.util.HashSet;

public class firstRepeated {
    public static Character findFirstRepeatedCharacter(String s) {
       if(s == null || s.length() == 0)
            return null;
        HashSet<Character> seen = new HashSet<>();
        for(char c : s.toCharArray()){
            if(seen.contains(c))
                return c;
            seen.add(c);
        }
        return null;
    }
    public static void main(String[] args) {
        // Test cases
        System.out.println(findFirstRepeatedCharacter("swiss")); // Output: s
        System.out.println(findFirstRepeatedCharacter("programming")); // Output: r
        System.out.println(findFirstRepeatedCharacter("abcdef")); // Output: null
        System.out.println(findFirstRepeatedCharacter("")); // Output: null
        System.out.println(findFirstRepeatedCharacter(null)); // Output: null
    }
}