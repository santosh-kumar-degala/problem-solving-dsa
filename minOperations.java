
import java.util.ArrayList;
import java.util.List;

public class minOperations {
    public int minOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int res = 0;
        for (int i : nums) {
            while (!list.isEmpty() && list.get(list.size() - 1) > i) {
                list.remove(list.size() - 1);
            }
            if (i == 0)
                continue;
            if (list.isEmpty() || list.get(list.size() - 1) < i) {
                res++;
                list.add(i);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        minOperations solution = new minOperations();
        int[] nums = {1, 5, 0, 3, 5};
        int result = solution.minOperations(nums);
        System.out.println("Minimum operations: " + result); // Output: Minimum operations: 3
    }
}