import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeAnagrams{
    public List<String> removeAnagrams(String[] words) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        result.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!areAnagrams(words[i], words[i - 1])) {
                result.add(words[i]);
            }
        }
        return result;
    }

    private boolean areAnagrams(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        return Arrays.equals(c1, c2);
    }
    public static void main(String[] args) {
        String[] words = {"abba","baba","bbaa","cd","cd"};
        removeAnagrams solver = new removeAnagrams();
        System.out.println(solver.removeAnagrams(words)); // Output: ["abba","cd"]
    }
}