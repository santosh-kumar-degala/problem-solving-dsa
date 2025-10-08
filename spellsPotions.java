import java.util.Arrays;

public class spellsPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int left = 0, right = potions.length - 1, index = potions.length;
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((long) spells[i] * potions[mid] >= success) {
                    index = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = potions.length - index;
        }
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        spellsPotions solver = new spellsPotions();
        int[] spells = {10, 20, 30};
        int[] potions = {1, 2, 3, 4, 5};
        long success = 100;
        int[] pairs = solver.successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(pairs)); // Output: [0, 1, 2]
    }
}