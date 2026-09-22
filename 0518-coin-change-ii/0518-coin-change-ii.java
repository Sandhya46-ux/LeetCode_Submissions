//Recursion
// class Solution {
//     public int change(int amount, int[] coins) {
//         return (int) solve(coins.length, amount, coins);
//     }

//     private long solve(int i, int amount, int[] coins) {
//         if (amount == 0) return 1;
//         if (i == 0) return 0;
//         if (amount < 0) return 0;

//         long pick = solve(i, amount - coins[i-1], coins);
//         long notPick = solve(i - 1, amount, coins);
//         return pick + notPick;
//     }
// }


//Memoization
class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        long[][] dp = new long[n + 1][amount + 1];
        for (long[] row : dp) Arrays.fill(row, -1);
        return (int) solve(n, amount, coins, dp);
    }

    private long solve(int i, int amount, int[] coins, long[][] dp) {
        if (amount == 0) return 1;
        if (i == 0) return 0;
        if (amount < 0) return 0;
        if (dp[i][amount] != -1) return dp[i][amount];

        long pick = solve(i, amount - coins[i-1], coins, dp);
        long notPick = solve(i -1, amount, coins, dp);

        return dp[i][amount] = (pick + notPick);
    }
}




// import java.util.*;

// class Solution {
//     public int change(int amount, int[] coins) {
//         int n = coins.length;
//         int[][] dp = new int[n + 1][amount + 1];
//         for (int i = 0; i <= n; i++) {
//             dp[i][0] = 1;
//         }
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= amount; j++) {
//                 dp[i][j] = dp[i - 1][j];
//                 if (coins[i - 1] <= j) {
//                     dp[i][j] += dp[i][j - coins[i - 1]];
//                 }
//             }
//         }

//         return dp[n][amount];
//     }
// }
