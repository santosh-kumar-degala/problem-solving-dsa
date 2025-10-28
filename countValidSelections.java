
public class countValidSelections {

    public int countValidSelections(int[] nums) {
        int valid = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (String dir : new String[]{"right", "left"}) {
                int[] arr = nums.clone();
                int curr = i;
                int step = dir.equals("right") ? 1 : -1;
                while (curr >= 0 && curr < nums.length) {
                    if (arr[curr] == 0) {
                        curr += step;
                    } else {
                        arr[curr]--;
                        step = -step; // Reverse direction
                        curr += step;
                    }
                }
                boolean allZero = true;
                for (int j : arr) {
                    if (j != 0) {
                        allZero = false;
                        break;
                    }
                }
                if (allZero) {
                    valid++;
                }
            }
        }
        return valid;
    }

    public static void main(String[] args) {
        countValidSelections cvs = new countValidSelections();
        int[] nums1 = {2, 3, 4, 0, 4, 1, 0};
        System.out.println(cvs.countValidSelections(nums1)); // Output: 0

        int[] nums2 = {1, 0, 2, 0, 3};
        System.out.println(cvs.countValidSelections(nums2)); // Output: 2

        int[] nums3 = {0, 0, 0};
        System.out.println(cvs.countValidSelections(nums3)); // Output: 6
    }
}
