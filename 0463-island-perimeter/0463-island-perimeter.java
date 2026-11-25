class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 1) {
                    return dfs(i, j, grid, vis);
                }
            }
        }
        return 0;
    }
    public int dfs(int i, int j, int[][] grid, boolean[][] vis) {

        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 1;
        }
        if (vis[i][j]) {
            return 0;
        }
        vis[i][j] = true;

        int peri = 0;
        peri += dfs(i + 1, j, grid, vis); 
        peri += dfs(i - 1, j, grid, vis); 
        peri += dfs(i, j + 1, grid, vis); 
        peri += dfs(i, j - 1, grid, vis); 

        return peri;
    }
}