// class Solution {
//     public int maxCoins(int[] nums) {
//         int n = nums.length;
//         int[] arr = new int[n + 2];
//         arr[0] = arr[n + 1] = 1;
//         for (int i = 0; i < n; i++) {
//             arr[i + 1] = nums[i];
//         }
//         return solve(arr, 1, n);
//     }
//     private int solve(int[] arr, int i, int j) {
//         if (i > j) {
//             return 0;
//         }
//         int maxCoins = 0;
//         for (int k = i; k <= j; k++) {
//             int coins = arr[i - 1] * arr[k] * arr[j + 1]+ solve(arr, i, k - 1)+ solve(arr, k + 1, j);
//             maxCoins = Math.max(maxCoins, coins);
//         }
//         return maxCoins;
//     }
// }



//MEMOIZATION
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(arr, 1, n, dp);
    }
    private int solve(int[] arr, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int maxCoins = 0;
        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1]+ solve(arr, i, k - 1, dp) + solve(arr, k + 1, j, dp);
            maxCoins = Math.max(maxCoins, coins);
        }
        return dp[i][j] = maxCoins;
    }
}