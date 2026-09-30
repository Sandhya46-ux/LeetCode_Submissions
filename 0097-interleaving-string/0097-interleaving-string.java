// class Solution {
//     public boolean isInterleave(String s1, String s2, String s3) { 
//         if (s1.length() + s2.length() != s3.length()) return false;
//         return solve(s1, s2, s3, s1.length(), s2.length(), s3.length());
//     }
//     public boolean solve(String s1, String s2, String s3, int i, int j, int k) {
//         if (i == 0 && j == 0 && k == 0) return true;
//         if (i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
//             if (solve(s1, s2, s3, i - 1, j, k - 1)) return true;
//         }
//         if (j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
//             if (solve(s1, s2, s3, i, j - 1, k - 1)) return true;
//         }
//         return false;
//     }
// }





class Solution{
    public boolean isInterleave(String s1, String s2, String s3){
        int n=s1.length();
        int m=s2.length();
        int l=s3.length();
        if(n+m!=l) return false;
        int [][][] dp=new int [n+1][m+1][s3.length()+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= l; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(s1, s2, s3, n, m, l, dp);
    }
    public boolean solve(String s1, String s2,String s3,int i,int j,int k, int[][][]dp){
        if (i == 0 && j == 0 && k == 0) return true;
        if(dp[i][j][k]!=-1){
            return dp[i][j][k]==1;
        }
        boolean ans = false;
        if (i > 0 && s1.charAt(i - 1) == s3.charAt(k - 1)) {
            ans = solve(s1, s2, s3, i - 1, j, k - 1, dp);
        }
        if (!ans && j > 0 && s2.charAt(j - 1) == s3.charAt(k - 1)) {
            ans = solve(s1, s2, s3, i, j - 1, k - 1, dp);
        }
        dp[i][j][k] = ans ? 1 : 0;
        return ans;
    }
}