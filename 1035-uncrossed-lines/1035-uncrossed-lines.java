// class Solution {
//     public int maxUncrossedLines(int[] nums1, int[] nums2) {
//         int n= nums1.length;
//         int m=nums2.length;
//         return solve(nums1,nums2,n, m);
//     }
//     public int solve(int[] nums1,int[] nums2, int i,int j){
//         if(i==0||j==0){
//             return 0;
//         }
//         if(nums1[i-1]==nums2[j-1]){
//             return 1+solve(nums1,nums2,i-1,j-1);
//         }else{
//             return Math.max(solve(nums1,nums2,i-1,j),solve(nums1,nums2,i,j-1));
//         }
//     }
// }

import java.util.*;
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n= nums1.length;
        int m=nums2.length;
        int[][] dp=new int[n+1][m+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums1,nums2,n, m,dp);
    }
    public int solve(int[] nums1,int[] nums2, int i,int j,int[][]dp){
        if(i==0||j==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(nums1[i-1]==nums2[j-1]){
            dp[i][j]= 1+solve(nums1,nums2,i-1,j-1,dp);
        }else{
            dp[i][j]= Math.max(solve(nums1,nums2,i-1,j,dp),solve(nums1,nums2,i,j-1,dp));
        }
        return dp[i][j];
    }
}

// import java.util.*;
// class Solution{
//     public int maxUncrossedLines(int[] nums1, int[] nums2){
//         int n=nums1.length;
//         int m=nums2.length;
//         int[][] dp=new int[n+1][m+1];
//         for(int i=0;i<=n;i++){
//             dp[i][0]=0;
//         }
//         for(int j=0;j<=m;j++){
//             dp[0][j]=0;
//         }
//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=m;j++){
//                 if(nums1[i-1]==nums2[j-1]){
//                     dp[i][j]=1+dp[i-1][j-1];
//                 }
//                 else{
//                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//                 }
//             }
//         }
//         return dp[n][m];
//     }
// }
