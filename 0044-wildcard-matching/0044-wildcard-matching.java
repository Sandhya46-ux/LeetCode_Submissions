// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int k = p.length();
//         return solve(n,k,s,p);
//     }
    
//     static boolean solve(int i , int j , String s,String p){
//         if(i == 0 && j == 0){
//             return true;
//         }
//         for(int k = 0; k < j ; k++){
//             if(p.charAt(k) != '*'){
//                 return false;
//             }
//             return true;
//         }
//         if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='?'){
//             return solve(i-1,j-1,s,p);
//         }
//         else if(p.charAt(j-1) =='*'){
//             return true;
//         }
//         else{
//             return false;
//         }
//     }
// }




// class Solution{
//     public boolean isMatch(String s, String p){
//         int n = s.length();
//         int k = p.length();
//         Boolean [][] dp=new Boolean[n+1][k+1];
    
//         return solve(n,k,s,p,dp);
//     }
//     public boolean solve(int i,int j,String s, String p,Boolean[][] dp){
//         if(i == 0 && j == 0){
//             return true;
//         }
//         if(dp[i][j] != null){
//             return dp[i][j];
//         }
//         if(j==0)return false;
//         for(int k = 0; k < j ; k++){
//             if(p.charAt(k) != '*'){
//                 return dp[i][j]=false;
//             }
//             return dp[i][j]= true;
//         }
//         if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) =='?'){
//             return dp[i][j]=solve(i-1,j-1,s,p,dp);
//         }
//         else if(p.charAt(j-1) =='*'){
//             return dp[i][j]=true;
//         }
//         else{
//             return dp[i][j]=false;
//         }
//     }
// }


import java.util.*;

class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] dp = new Boolean[n+1][m+1];
        return solve(n, m, s, p, dp);
    }

    private boolean solve(int i, int j, String s, String p, Boolean[][] dp) {
        if (i == 0 && j == 0) return true;
        if (j == 0) return false;

        if (dp[i][j] != null) return dp[i][j];

        if (i == 0) {
            for (int k = 0; k < j; k++) {
                if (p.charAt(k) != '*') return dp[i][j] = false;
            }
            return dp[i][j] = true;
        }
        if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
            return dp[i][j] = solve(i-1, j-1, s, p, dp);
        } else if (p.charAt(j-1) == '*') {
            return dp[i][j] = solve(i, j-1, s, p, dp) || solve(i-1, j, s, p, dp);
        } else {
            return dp[i][j] = false;
        }
    }
}
