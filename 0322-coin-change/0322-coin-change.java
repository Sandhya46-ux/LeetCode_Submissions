// //Recursion
// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int result = solve(coins.length - 1, coins, amount);
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }
//     private int solve(int i, int[] coins, int amount) {
//         if (amount == 0) return 0;
//         if (i < 0 || amount < 0) return Integer.MAX_VALUE;

//         int pick = Integer.MAX_VALUE;
//         if (coins[i] <= amount) {
//             int res = solve(i, coins, amount - coins[i]);
//             if (res != Integer.MAX_VALUE) pick = res + 1;
//         }
//         int notPick = solve(i - 1, coins, amount);
//         return Math.min(pick, notPick);
//     }
// }



//Memoization
// import java.util.*;

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int[][] dp = new int[coins.length+1][amount + 1];
//         for (int[] row : dp){
//             Arrays.fill(row, -1);
//         }    
//         int result = solve(coins.length, coins, amount, dp);
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }
//     private int solve(int i, int[] coins, int amount, int[][] dp) {
//         if (amount == 0) return 0;
//         if (i <= 0 || amount < 0) return Integer.MAX_VALUE;
//         if (dp[i][amount] != -1) return dp[i][amount];

//         int pick = Integer.MAX_VALUE;
//         if (coins[i-1] <= amount) {
//             int res = solve(i, coins, amount - coins[i-1], dp);
//             if (res != Integer.MAX_VALUE) pick = res + 1;
//         }
//         int notPick = solve(i - 1, coins, amount, dp);
//         dp[i][amount] = Math.min(pick, notPick);
//         return dp[i][amount];
//     }
// }


//Tabulation
import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = Integer.MAX_VALUE; 
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0; 
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                int notPick = dp[i - 1][j];
                int pick = Integer.MAX_VALUE;
                if (coins[i - 1] <= j && dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                    pick = 1 + dp[i][j - coins[i - 1]];
                }
                dp[i][j] = Math.min(pick, notPick);
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}
