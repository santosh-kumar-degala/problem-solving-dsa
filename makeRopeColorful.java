public class makeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return totalTime;
    }
    public static void main(String[] args) {
        makeRopeColorful solution = new makeRopeColorful();
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        int result = solution.minCost(colors, neededTime);
        System.out.println("Minimum cost to make the rope colorful: " + result); // Output: 3
    }

}