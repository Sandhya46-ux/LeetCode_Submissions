// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         return solve(dungeon, 0, 0);
//     }
//     int solve(int[][] grid, int i, int j) {
//         int m = grid.length;
//         int n = grid[0].length;
//         if (i == m - 1 && j == n - 1) {
//             if (grid[i][j] < 0) {
//                 return 1 - grid[i][j];
//             }
//             return 1;
//         }
//         if (i >= m || j >= n) {
//             return Integer.MAX_VALUE;
//         }
//         int down = solve(grid, i + 1, j);
//         int right = solve(grid, i, j + 1);
//         int minHealth = Math.min(down, right);
//         int temp = minHealth - grid[i][j];

//         if (temp <= 0) {
//             return 1;
//         }else{
//         return temp;
//         }
//     }
// }



import java.util.*;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(dungeon, 0, 0, dp);
    }

    int solve(int[][] grid, int i, int j, int[][] dp) {

        int m = grid.length;
        int n = grid[0].length;
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - grid[i][j]);
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = solve(grid, i + 1, j, dp);
        int right = solve(grid, i, j + 1, dp);

        int minHealth = Math.min(down, right);

        int temp = minHealth - grid[i][j];

        if (temp <= 0) {
            return dp[i][j] = 1;
        }
        return dp[i][j] = temp;
    }
}
