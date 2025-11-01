import java.util.*;

public class modifyList {
    public LinkedList<Integer> modifiedList(int[] nums, LinkedList<Integer> list) {
        Set<Integer> hset = new HashSet<>();
        for (int i : nums) {
            hset.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (hset.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        modifyList ml = new modifyList();
        int[] nums = {1, 2, 3};
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> modifiedList = ml.modifiedList(nums, list);

        System.out.print("Modified List: ");
        for (int val : modifiedList) {
            System.out.print(val + " ");
        }
    }
}