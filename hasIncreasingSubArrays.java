import java.util.Arrays;
import java.util.List;

public class hasIncreasingSubArrays{
    public static boolean hasIncreasingSubArray(List<Integer> nums, int k) {
       int count = 1;
       int current = 0;
       int res = 0;
       for(int i=1; i<nums.size(); i++){
            if(nums.get(i) > nums.get(i-1))
                count++;
            else{
                current = count;
                count = 1;
            }
            res = Math.max(res, Math.min(current, count));
            res = Math.max(res, count/2);
       }
       return res >= k;
    }
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(-2,5,7,8,2,3,4,5,1);
        System.out.println(hasIncreasingSubArray(nums, 4)); // Output: true
    }
}