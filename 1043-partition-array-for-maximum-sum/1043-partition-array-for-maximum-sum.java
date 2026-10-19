
// class Solution {
//     public int maxSumAfterPartitioning(int[] arr, int k) {
//         return solve(0, arr, k);
//     }
//     private int solve(int i, int[] arr, int k) {
//         if (i==arr.length) {
//             return 0;
//         }
//         int max=0;
//         int maxSum=0;
//         for (int j = i; j<Math.min(i+k,arr.length);j++) {
//             max = Math.max(max,arr[j]);
//             int len = j - i + 1;
//             int sum = (max * len) + solve(j + 1, arr, k);
//             maxSum = Math.max(maxSum, sum);
//         }
//         return maxSum;
//     }
// }



//Memo
import java.util.Arrays;

class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return solve(0, arr, k, dp);
    }
    private int solve(int i, int[] arr, int k, int[] dp) {
        if (i == arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int max = 0;
        int maxSum = 0;
        for (int j = i; j < Math.min(i + k, arr.length); j++) {
            max = Math.max(max, arr[j]);
            int len = j - i + 1;
            int sum = (max * len) + solve(j + 1, arr, k, dp);
            maxSum = Math.max(maxSum, sum);
        }
        return dp[i] = maxSum;
    }
}