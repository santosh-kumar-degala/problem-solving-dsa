
import java.util.*;

public class findXSum {

    public int[] findSum(int[] nums, int k, int x) {
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i <= nums.length - k; i++) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            }
            List<int[]> freq = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                freq.add(new int[]{entry.getValue(), entry.getKey()});
            }
            freq.sort((a, b) -> b[0] != a[0] ? b[0] - a[0] : b[1] - a[1]);
            int sum = 0;
            for (int j = 0; j < x && j < freq.size(); j++) {
                sum += freq.get(j)[0] * freq.get(j)[1];
            }
            res[i] = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        findXSum solver = new findXSum();
        int[] nums = {1, 1, 2, 2, 3, 4, 2, 3};
        int k = 6, x = 2;
        System.out.println(Arrays.toString(solver.findSum(nums, k, x)));
    }
}
