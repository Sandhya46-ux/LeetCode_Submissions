//Rcursion
// import java.util.*;
// class Solution {
//     public int minCost(int n, int[] cuts) {
//         Arrays.sort(cuts);
//         int l = cuts.length;
//         int[] arr = new int[l + 2];
//         arr[0] = 0;
//         arr[l + 1] = n;
//         for (int i = 0; i < l; i++) {
//             arr[i + 1] = cuts[i];
//         }
//         return solve(1, l, arr);
//     }
//     public int solve(int i, int j, int[] cuts) {
//         if (i>j) {
//             return 0;
//         }
//         int min=Integer.MAX_VALUE;
//         for (int k=i; k<=j; k++) {
//             int cost = cuts[j+1] - cuts[i-1]
//                      + solve(i, k-1, cuts)
//                      + solve(k+1, j, cuts);

//             min=Math.min(min, cost);
//         }
//         return min;
//     }
// }

//Memoization
import java.util.*;
class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int l = cuts.length;
        int[] arr = new int[l + 2];
        arr[0] = 0;
        arr[l + 1] = n;
        for (int i = 0; i < l; i++) {
            arr[i + 1] = cuts[i];
        }
        int[][] dp = new int[l + 2][l + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(1, l, arr, dp);
    }
    public int solve(int i, int j,int[] cuts,int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min=Integer.MAX_VALUE;
        for (int k=i; k<=j; k++) {
            int cost = cuts[j+1] - cuts[i-1]
                     + solve(i, k-1, cuts,dp)
                     + solve(k+1, j, cuts,dp);

            min=Math.min(min, cost);
        }
        return dp[i][j]=min;
    }
}
