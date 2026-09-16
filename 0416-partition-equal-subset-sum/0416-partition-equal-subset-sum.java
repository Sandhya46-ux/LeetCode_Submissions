// class Solution {
//     public boolean canPartition(int[] nums) {
//         int total = 0;
//         int n=nums.length;
//         for (int num : nums) {
//             total += num;
//         }
//         if (total % 2 != 0) {
//             return false;
//         }
//         int subsetSum = total / 2;
//         return solve(nums, n-1, subsetSum);
//     }
//     private boolean solve(int[] nums, int i, int currentSum) {
//         if (currentSum == 0) {
//             return true;
//         }
//         if (i<0) {
//             return false;
//         }
//         boolean skip=solve(nums, i - 1, currentSum);
//         boolean select = false;
//         if (currentSum >= nums[i]) {
//             select=solve(nums, i - 1, currentSum - nums[i]);
//         }
//         return skip || select;
//     }
// }


//Memoization
import java.util.*;
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }
        int subsetSum = total / 2;
        int[][] dp = new int[nums.length][subsetSum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return memo(nums, nums.length - 1, subsetSum, dp) == 1;
    }
    private int memo(int[] nums, int i, int currentSum, int[][] dp) {
        if (currentSum == 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (dp[i][currentSum] != -1) {
            return dp[i][currentSum];
        }
        int skip = memo(nums, i - 1, currentSum, dp);
        int select = 0;
        if (currentSum >= nums[i]) {
            select = memo(nums, i - 1,currentSum - nums[i], dp);
        }
        return dp[i][currentSum] = skip | select;
    }
}