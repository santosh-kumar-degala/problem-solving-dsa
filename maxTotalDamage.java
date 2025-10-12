
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class maxTotalDamage {

    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Integer> hmap = new TreeMap<>();
        for (int p : power) {
            hmap.put(p, hmap.getOrDefault(p, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(hmap.keySet());
        long[] dp = new long[list.size() + 1];
        for (int i = 0; i < list.size(); i++) {
            long damage = (long) list.get(i) * hmap.get(list.get(i));
            int j = i - 1;
            while (j >= 0 && list.get(j) >= list.get(i) - 2) {
                j--;
            }
            dp[i + 1] = Math.max(dp[i], dp[j + 1] + damage);
        }
        return dp[list.size()];
    }

    public static void main(String[] args) {
        int[] damage = {7, 1, 6, 6, 6};
        maxTotalDamage solver = new maxTotalDamage();
        System.out.println(solver.maximumTotalDamage(damage)); // Output: 19
    }
}
