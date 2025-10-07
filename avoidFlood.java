import java.util.*;

public class avoidFlood {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Map<Integer, Integer> lakeLastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                res[i] = 1; // default, will update if needed
            } else {
                int lake = rains[i];
                if (lakeLastRain.containsKey(lake)) {
                    Integer dryDay = dryDays.higher(lakeLastRain.get(lake));
                    if (dryDay == null) return new int[0];
                    res[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lakeLastRain.put(lake, i);
                res[i] = -1;
            }
        }
        return res;
    }

    // Example usage
    public static void main(String[] args) {
        avoidFlood af = new avoidFlood();
        int[] rains = {1,2,0,1,2};
        System.out.println(Arrays.toString(af.avoidFlood(rains)));
    }
}