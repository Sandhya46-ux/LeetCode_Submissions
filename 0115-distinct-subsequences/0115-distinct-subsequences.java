// class Solution {
//     public int numDistinct(String s, String t) {
//         return solve(s, t, 0, 0);
//     }
//     private int solve(String s, String t, int i, int j) {
//         if (j == t.length()) return 1;
//         if (i == s.length()) return 0;
//         int ans = solve(s, t, i + 1, j);
//         if (s.charAt(i) == t.charAt(j)) {
//             ans += solve(s, t, i + 1, j + 1);
//         }
//         return ans;
//     }
// }


class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row :dp) Arrays.fill(row,-1);
        return solve(s,t,0,0,dp);
    }
    private int solve(String s, String t,int i,int j,int[][] dp) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (dp[i][j] !=-1) return dp[i][j];

        int ans = solve(s,t,i+1,j,dp);
        if (s.charAt(i) == t.charAt(j)) {
            ans += solve(s,t,i+1, j+1,dp);
        }
        dp[i][j] = ans;
        return ans;
    }
}
