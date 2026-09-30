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


// import java.util.*;

// class Solution {
//     public boolean isMatch(String s, String p) {
//         int n = s.length();
//         int m = p.length();
//         Boolean[][] dp = new Boolean[n+1][m+1];
//         return solve(n, m, s, p, dp);
//     }

//     private boolean solve(int i, int j, String s, String p, Boolean[][] dp) {
//         if (i == 0 && j == 0) return true;
//         if (j == 0) return false;

//         if (dp[i][j] != null) return dp[i][j];

//         if (i == 0) {
//             for (int k = 0; k < j; k++) {
//                 if (p.charAt(k) != '*') return dp[i][j] = false;
//             }
//             return dp[i][j] = true;
//         }
//         if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
//             return dp[i][j] = solve(i-1, j-1, s, p, dp);
//         } else if (p.charAt(j-1) == '*') {
//             return dp[i][j] = solve(i, j-1, s, p, dp) || solve(i-1, j, s, p, dp);
//         } else {
//             return dp[i][j] = false;
//         }
//     }
// }





class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            if (p.charAt(j-1) == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = p.charAt(j-1);
                char sc = s.charAt(i-1);

                if (pc == sc || pc == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
