import java.util.Arrays;
class Solution {

    //RECURSION
    // public int rob(int[] nums) {
    //     return robPure(nums, 0, 0, 0);
    // }

    // private int robPure(int[] nums, int i, int steal, int skip) {
    //     if (i == nums.length) {
    //         return steal;
    //     }
    //     int current = Math.max(steal, skip + nums[i]);
        
    //     return robPure(nums, i + 1, current, steal);
    // }


      //MEMOIZATION
     public int rob(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            dp.add(-1);
        }
        return robFrom(nums, 0, dp);
    }
    private int robFrom(int[] nums, int i, ArrayList<Integer> dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (dp.get(i) != -1) {
            return dp.get(i);
        }
        int steal = nums[i] + robFrom(nums, i + 2, dp);
        int skip = robFrom(nums, i + 1, dp);
        int result=Math.max(steal,skip);
        dp.set(i,result);
        return result;
    }
}

    //Tabulation
//     public int rob(int[] nums){
//         int n=nums.length;
//         if(n==0) return 0;
//         if(n==1) return nums[0];
//         int[] dp=new int[n];
//         dp[0]=0;
//         dp[1]=Math.max(nums[0],nums[1]);
//         for(int i=2;i<n;i++){
//             dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
//         }
//         return dp[n-1];
//     }
// }
