import java.util.Arrays;

public class maxDistinctElements {
    public static int maxDistinctElements(int[] nums, int k) {
       Arrays.sort(nums);
       int count =0;
       int prev = Integer.MIN_VALUE;
         for(int i : nums){
              int curr = Math.min(Math.max(i-k, prev+1), i+k);
              if(curr != prev){
                  count++;
                  prev = curr;
              }
         }
       return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4};
        int k = 2;
        int result = maxDistinctElements(nums, k);
        System.out.println("The maximum number of distinct elements is: " + result);
    }
}
