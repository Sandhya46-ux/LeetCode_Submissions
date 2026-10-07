//ITs is of Space-optimized code
class Solution{
    public int lengthOfLIS(int[] nums){
        int n=nums.length;
        int[] dp= new int[n+1];
        for(int i=n-1;i>=0;i--){
            for(int prev=i-1;prev>=-1;prev--){
                int nottake=dp[prev+1];
                int take=0;
                if(prev==-1|| nums[i]>nums[prev]){
                    take=1+dp[i+1];
                }
                dp[prev+1]=Math.max(nottake,take);
            }
        }
        return dp[0];
    }
}
