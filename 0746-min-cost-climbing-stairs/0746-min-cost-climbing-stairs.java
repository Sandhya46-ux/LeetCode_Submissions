class Solution {
    //Recursion
    // public int minCost(int[] cost, int i) {
    //     if (i >= cost.length) {
    //         return 0;
    //     }
    //     int oneStep = cost[i] +minCost(cost, i + 1);
    //     int twoStep = cost[i] +minCost(cost, i + 2);
    //     return  Math.min(oneStep, twoStep);
    // }
    // public int minCostClimbingStairs(int[] cost) {
    //     return Math.min(minCost(cost, 0),minCost(cost, 1));
    // }


    //Memoization
    // public int minCost(int[] cost, int i,ArrayList<Integer> dp) {
    //     if (i >= cost.length) {
    //         return 0;
    //     }
    //     if(dp.get(i)!=-1){
    //         return dp.get(i);
    //     }

    //     int oneStep = cost[i] +minCost(cost, i + 1,dp);
    //     int twoStep = cost[i] +minCost(cost, i + 2,dp);
    //     int result=Math.min(oneStep, twoStep);
    //     dp.set(i,result);
    //     return result;
    // }
    // public int minCostClimbingStairs(int[] cost) {
    //     ArrayList<Integer> dp=new ArrayList<>();
    //     for(int i=0;i<cost.length;i++){
    //         dp.add(-1);
    //     }
    //     return Math.min(minCost(cost, 0,dp),minCost(cost, 1,dp));
    // }

//Tabulation
public int minCostClimbingStairs(int[] cost){
    int n=cost.length;
    int[] dp=new int[n+1];
    dp[n]=0;
    dp[n-1]=cost[n-1];
    for(int i=n-2;i>=0;i--){
        int r=dp[i+1];
        int l=dp[i+2];
        dp[i]=cost[i]+Math.min(r,l);
    }
    return Math.min(dp[0],dp[1]);
}


}