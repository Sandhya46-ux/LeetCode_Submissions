// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         return solve(nums,0,-1);
//     }
//     public int solve(int[] nums,int i, int prev){
//         if(i==nums.length)return 0;
//         int nottake=solve(nums,i+1,prev);
//         int take=0;
//         if(prev==-1||nums[prev]<nums[i]){
//             take=1+solve(nums,i+1,i);
//         }
//         return Math.max(nottake,take);
//     }
// }


class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int[][] dp=new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(nums,0,-1,dp);
    }
    public int solve(int[] nums,int i, int prev,int[][]dp){
        if(i==nums.length)return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int nottake=solve(nums,i+1,prev,dp);
        int take=0;
        if(prev==-1||nums[prev]<nums[i]){
            take=1+solve(nums,i+1,i,dp);
        }
        return dp[i][prev+1]=Math.max(nottake,take);
    }
}