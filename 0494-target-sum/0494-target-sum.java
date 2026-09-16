import java.util.*;
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        int offset = total;
        int[][] dp = new int[n + 1][2 * total + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memo(nums, 0, 0, target, offset, dp);
    }
    public int memo(int[] nums, int i, int current,int target, int offset, int[][] dp) {
        if (i == nums.length) {
            if (current == target) {
                return 1;
            }
            return 0;
        }
        int index = current + offset;
        if (dp[i][index] != -1) {
            return dp[i][index];
        }
        int plus = memo(nums, i + 1, current + nums[i],target, offset, dp);
        int minus = memo(nums, i + 1, current - nums[i],target, offset, dp);
        return dp[i][index] = plus + minus;
    }
}