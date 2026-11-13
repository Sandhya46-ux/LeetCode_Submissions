// class Solution {
//     public int rob(int[] nums) {
//         int n = nums.length;
//         if (n == 1) {
//             return nums[0];
//         }
//         return Math.max(solve(nums,0,n-2),solve(nums,1,n-1));
//     }
//     public int solve(int[] nums, int i, int end) {
//         if (i > end) {
//             return 0;
//         }
//         int pick = nums[i] +solve(nums, i + 2, end);
//         int notPick = solve(nums, i + 1, end);
//         return Math.max(pick, notPick);
//     }
// }





import java.util.*;

class Solution {
    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp1 = new int[n];
        Arrays.fill(dp1, -1);

        int case1 = solve(nums, 0, n - 2, dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2, -1);

        int case2 = solve(nums, 1, n - 1, dp2);

        return Math.max(case1, case2);
    }

    int solve(int[] nums, int i, int end, int[] dp) {

        if (i > end) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int pick = nums[i] + solve(nums, i + 2, end, dp);
        int notPick = solve(nums, i + 1, end, dp);

        return dp[i] = Math.max(pick, notPick);
    }
}
