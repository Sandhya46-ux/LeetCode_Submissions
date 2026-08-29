import java.util.ArrayList;
import java.util.Collections;
class Solution {
    //Recursion

    // public int climbStairs(int n) {
    //     if(n==0){
    //         return 1;
    //     }
    //     if(n==1){
    //         return 1;
    //     }
    //     return climbStairs(n-1) + climbStairs(n-2);}

    

    // Memoization
    public int climbStairsMemo(int n, ArrayList<Integer> dp){
        if (n == 0 || n == 1) {
            return 1; 
        }
        if (dp.get(n) != -1) {
            return dp.get(n);
        }
        int result = climbStairsMemo(n - 1, dp) + climbStairsMemo(n - 2, dp);
        dp.set(n, result);
        return result;
    }

    public int climbStairs(int n) {
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));
        return climbStairsMemo(n, dp);
    }


        
        
// //Tabulation

//     public int climbStairs(int n) {
//     if (n <= 2) {
//         return n;
//     }
//     ArrayList<Integer> dp = new ArrayList<>(n + 1);
//     for (int i = 0; i <= n; i++) {
//         dp.add(0);
//     }
//     dp.set(1, 1);
//     dp.set(2, 2);
//     for (int i = 3; i <= n; i++) {
//         int ways = dp.get(i - 1) + dp.get(i - 2);
//         dp.set(i, ways);
//     }
    
//     return dp.get(n);}

//tabulation using array
// public int climbStairs(int n){ 
// if(n <= 2) {
//  return n; 
//  }
//  int dp[]=new int[n+1]; 
//  dp[1]=1; 
//  dp[2]=2; 
//   for(int i=3;i<=n;i++){ 
//   dp[i]=dp[i-1]+dp[i-2]; } 
//   return dp[n];} 

}
