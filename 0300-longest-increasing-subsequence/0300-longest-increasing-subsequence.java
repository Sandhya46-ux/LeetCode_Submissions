//ITS IS FROM n-0
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         return solve(nums, n ,0);
//     }
//     private int solve(int[] nums, int i, int prev) {
//         if (i==0) {
//             return 0;
//         }
//         int notTake = solve(nums, i - 1, prev);
//         int take = 0;
//         if (prev==0 ||nums[i-1]<nums[prev-1]) 1{
//             take = 1 + solve(nums, i - 1, i);
//         }
//         return Math.max(take, notTake);
//     }
// }


// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n + 1][n + 1];
//         for (int i = 0; i <= n; i++) {
//             for (int j = 0; j <= n; j++) {
//                 dp[i][j] = -1;
//             }
//         }
//         return solve(nums, n, 0, dp);
//     }
//     private int solve(int[] nums, int i, int prev, int[][] dp) {
//         if (i == 0) {
//             return 0;
//         }
//         if (dp[i][prev] != -1) {
//             return dp[i][prev];
//         } 
//         int notTake = solve(nums, i - 1, prev, dp);
//         int take = 0;
//         if (prev == 0 || nums[i - 1] < nums[prev - 1]) {
//             take = 1 + solve(nums, i - 1, i, dp);
//         }
//         dp[i][prev] = Math.max(take, notTake);
//         return dp[i][prev];
//     }
// }



class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int prev = 0; prev <= n; prev++) {
                int notTake = dp[i - 1][prev];
                int take = 0;
                if (prev == 0 || nums[i - 1] < nums[prev - 1]) {
                    take = 1 + dp[i - 1][i];
                }
                dp[i][prev] = Math.max(take, notTake);
            }
        }
        return dp[n][0];
    }
}