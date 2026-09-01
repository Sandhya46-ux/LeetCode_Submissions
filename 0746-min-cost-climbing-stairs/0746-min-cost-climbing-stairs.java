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
    public int minCost(int[] cost, int i,ArrayList<Integer> dp) {
        if (i >= cost.length) {
            return 0;
        }
        if(dp.get(i)!=-1){
            return dp.get(i);
        }

        int oneStep = cost[i] +minCost(cost, i + 1,dp);
        int twoStep = cost[i] +minCost(cost, i + 2,dp);
        int result=Math.min(oneStep, twoStep);
        dp.set(i,result);
        return result;
    }
    public int minCostClimbingStairs(int[] cost) {
        ArrayList<Integer> dp=new ArrayList<>();
        for(int i=0;i<cost.length;i++){
            dp.add(-1);
        }
        return Math.min(minCost(cost, 0,dp),minCost(cost, 1,dp));
    }
}