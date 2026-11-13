// class Solution {
//     public int minCut(String s) {
//         int n=s.length();
//         int[] dp=new int[n];
//         Arrays.fill(dp,-1);
//         return solve(s,0,dp)-1;
//         // return solve(s, 0) - 1;
//     }
//     // int solve(String s, int i){
//     //     int n=s.length();
//     //     if(i==n) return 0;
//     //     int ans = n;
//     //     for (int j = i; j < n; j++) {
//     //         if (isPalindrome(s, i, j)) {
//     //             int part = 1 + solve(s, j + 1);
//     //             ans = Math.min(ans, part);
//     //         }
//     //     }
//     //     return ans;
//     // }

//     int solve(String s,int i,int[] dp){
//         int n=s.length();
//         if(i==n) return 0;
//         if(dp[i]!=-1) return dp[i];
//         int maxi=n;
//         for(int j=i;j<n;j++){
//             if(isPalindrome(s,i,j)){
//                 int part=1+solve(s,j+1,dp);
//                 maxi=Math.min(maxi,part);
//             }
//         }
//         return dp[i]=maxi;
//     }
//     boolean isPalindrome(String s, int i, int j){
//         if(i>=j) return true;
//         if(s.charAt(i)!=s.charAt(j)) return false;
//         return isPalindrome(s,i+1,j-1);
//     }
// }




class Solution {
    public int minCut(String s) {

        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j)) {

                    if (j - i <= 1 || isPal[i + 1][j - 1]) {
                        isPal[i][j] = true;
                    }
                }
            }
        }
        int[] dp = new int[n + 1];

        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            int mini = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {

                if (isPal[i][j]) {

                    int partitions = 1 + dp[j + 1];

                    mini = Math.min(mini, partitions);
                }
            }

            dp[i] = mini;
        }
        return dp[0] - 1;
    }
}
