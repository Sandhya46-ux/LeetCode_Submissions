// class Solution {
//     public int numDistinct(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         return solve(s, t, n, m);
//     }

//     private int solve(String s, String t, int i, int j) {
//         if (j == 0) return 1; 
//         if (i == 0) return 0; 
//         if (s.charAt(i - 1) == t.charAt(j - 1)) {
//             return solve(s, t, i - 1, j - 1) + solve(s, t, i - 1, j);
//         } else {
//             return solve(s, t, i - 1, j);
//         }
//     }
// }





// class Solution {
//     public int numDistinct(String s, String t) {
//            int n=s.length();
//            int m=t.length();
//         return solve(s, t, n-1, m-1);
//     }
//     private int solve(String s, String t, int i, int j) {
//         if (j <0) return 1;
//         if (i <0) return 0;
//         if (s.charAt(i - 1) == t.charAt(j - 1)) {
//             return solve(s, t, i - 1, j - 1) + solve(s, t, i - 1, j);
//             } else {
//                 return solve(s, t, i - 1, j);
//             }
//     }
// }






class Solution {
    public int numDistinct(String s, String t) {
           int n=s.length();
           int m=t.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row :dp) Arrays.fill(row,-1);
        return solve(s,t,n,m,dp);
    }
    private int solve(String s, String t,int i,int j,int[][] dp) {
        if (j==0) return 1;
        if (i==0) return 0;
        if (dp[i][j] !=-1) return dp[i][j];

        if (s.charAt(i - 1) == t.charAt(j - 1)) {
            dp[i][j]= solve(s, t, i - 1, j - 1,dp) + solve(s, t, i - 1, j,dp);
        } else {
           dp[i][j]= solve(s, t, i - 1, j,dp);
        }
        return dp[i][j];
    }
}


// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {

//         int n=text1.length();
//         int m=text2.length();

//         int[][] dp=new int[n+1][m+1];

//         for(int i=1;i<=n;i++){
//             for(int j=1;j<=m;j++){

//                 if(text1.charAt(i-1)==text2.charAt(j-1))
//                     dp[i][j]=1+dp[i-1][j-1];
//                 else
//                     dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
//             }
//         }
//         return dp[n][m];
//     }
// }