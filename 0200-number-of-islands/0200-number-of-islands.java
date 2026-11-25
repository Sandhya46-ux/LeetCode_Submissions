class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(int i, int j, int[][] vis, char[][] grid) {

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});

        int m = grid.length;
        int n = grid[0].length;

        vis[i][j] = 1;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for (int k = 0; k < 4; k++) {

                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == '1' &&  vis[nx][ny] == 0) {

                    vis[nx][ny] = 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}