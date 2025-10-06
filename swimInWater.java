import java.util.*;

public class swimInWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0], y = curr[1], time = curr[2];
            if (x == n - 1 && y == n - 1) 
                return time;
            int key = x * n + y;
            if (visited.contains(key)) 
                continue;
            visited.add(key);
            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                int nkey = nx * n + ny;
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited.contains(nkey)) {
                    pq.offer(new int[]{nx, ny, Math.max(time, grid[nx][ny])});
                }
            }
        }
        return -1;
    }

    // Example usage
    public static void main(String[] args) {
        swimInWater solver = new swimInWater();
        int[][] grid = {
            {0,2},
            {1,3}
        };
        System.out.println(solver.swimInWater(grid)); // Output: 3
    }
}