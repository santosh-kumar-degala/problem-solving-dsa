
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class smallestLexString {

    public static String smallestLexString(String s, int a, int b) {
        int n = s.length();
        b = b % n;
        String smallest = s;
        Queue<String> queue;
        queue = new LinkedList<>();
        queue.add(s);
        Set<String> visited = new HashSet<>();
        visited.add(s);
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
            char[] chars = curr.toCharArray();
            for (int i = 1; i < n; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String added = new String(chars);
            if (visited.add(added)) {
                queue.add(added);
            }
            String rotated = curr.substring(n - b) + curr.substring(0, n - b);
            if (visited.add(rotated)) {
                queue.add(rotated);
            }
        }
        return smallest;
    }

    public static void main(String[] args) {
        String s = "5525";
        int a = 9;
        int b = 2;
        String result = smallestLexString(s, a, b);
        System.out.println("The smallest lexicographical string is: " + result);
    }
}
