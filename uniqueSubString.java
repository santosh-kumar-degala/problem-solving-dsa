import java.util.HashSet;
import java.util.Set;

public class uniqueSubString {
    public static boolean hasUniqueSubstring(String s, int len) {
        if (s == null || len > s.length() || len <= 0) 
            return false;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i <= s.length() - len; i++) {
            set.clear();
            boolean unique = true;
            for (int j = i; j < i + len; j++) {
                if (!set.add(s.charAt(j))) {
                    unique = false;
                    break;
                }
            }
            if (unique) 
                return true;
        }
        return false;
    }

    public static Set<String> findAllUniqueSubstrings(String s, int len) {
        Set<String> result = new HashSet<>();
        if (s == null || len > s.length() || len <= 0)
            return result;
        for (int i = 0; i <= s.length() - len; i++) {
            String sub = s.substring(i, i + len);
            Set<Character> chars = new HashSet<>();
            boolean unique = true;
            for (char c : sub.toCharArray()) {
                if (!chars.add(c)) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                result.add(sub);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int len = 3;
        System.out.println(hasUniqueSubstring(s, len)); // true
        System.out.println(findAllUniqueSubstrings(s, len)); // [abc, bca, cab]
    }
}