class Solution {
//RECURSION
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;

//         return minPathSumRec(m - 1, n - 1, grid);
//     }

//     public int minPathSumRec(int i, int j, int[][] grid) {
//         if (i == 0 && j == 0) {
//             return grid[0][0];
//         }
//         if (i < 0 || j < 0) {
//             return Integer.MAX_VALUE;
//         }
//         int up = minPathSumRec(i - 1, j, grid);
//         int left = minPathSumRec(i, j - 1, grid);
//         return grid[i][j] + Math.min(up, left);
//     }
// }

//MEMOIZATION

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(-1);
            }
            dp.add(row);
        }

        return minPathSumMemo(m - 1, n - 1, grid, dp);
    }

    public int minPathSumMemo(int i, int j, int[][] grid,
                              ArrayList<ArrayList<Integer>> dp) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp.get(i).get(j) != -1) {
            return dp.get(i).get(j);
        }

        int up = minPathSumMemo(i - 1, j, grid, dp);
        int left = minPathSumMemo(i, j - 1, grid, dp);

        int ans = grid[i][j] + Math.min(up, left);

        dp.get(i).set(j, ans);

        return ans;
    }
}