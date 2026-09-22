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
import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        int result = solve(coins, amount, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int solve(int[] coins, int amount, int[] dp) {
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -1) return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int i=0;i<coins.length;i++) {
            int res = solve(coins, amount - coins[i], dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res + 1);
            }
        }
        dp[amount] = min;
        return min;
    }
}
