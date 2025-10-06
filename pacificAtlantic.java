import java.util.*;

public class pacificAtlantic {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return result;
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        int m = heights.length, n = heights[0].length;
        visited[i][j] = true;
        int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};
        for (int[] dir : DIRS) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || heights[x][y] < heights[i][j]) continue;
            dfs(heights, visited, x, y);
        }
    }

    // Example usage
    public static void main(String[] args) {
        pacificAtlantic solver = new pacificAtlantic();
        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        List<List<Integer>> result = solver.pacificAtlantic(heights);
        System.out.println(result);
    }
}
