import java.util.HashMap;
import java.util.Map;
public class getSneakyNumbers{
    public int[] getSneakyNumbers(int[] nums) {
        int[] res = new int[2];
        int j =0;
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0) + 1);
            if(hmap.get(nums[i]) == 2){
                res[j++] = nums[i];
                if(j == 2)
                    break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        getSneakyNumbers gsn = new getSneakyNumbers();
        int[] nums = {4,3,2,7,8,2,3,1};
        int[] result = gsn.getSneakyNumbers(nums);
        System.out.println("Sneaky Numbers: " + result[0] + ", " + result[1]);
    }
}