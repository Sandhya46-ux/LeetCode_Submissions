class Solution {

//Recursion
    // public int minPathSum(int i,int j) {

//         return minPathSumRec(m - 1, n - 1);
//     }
//
//     public int minPathSumRec(int i, int j) {
//         if (i == 0 && j == 0) {
//             return 1;
//         }
//         if (i < 0 || j < 0) {
//             return 0;
//         }
//         int up = minPathSumRec(i - 1, j);
//         int left = minPathSumRec(i, j - 1);
//         return up+left);
//     }

//MEMOIZATION
//     public int uniquePaths(int m,int n ) {
//         ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
//         for(int i=0;i<m;i++){
//             ArrayList<Integer> row=new ArrayList<>();
//             for(int j=0;j<n;j++){
//                 row.add(-1);
//             }
//             dp.add(row);
//         }
//         return uniquePathsSum(m - 1, n - 1,dp);
//     }

//     public int uniquePathsSum(int i, int j,ArrayList<ArrayList<Integer>>dp) {
//         if (i == 0 && j == 0) {
//             return 1;
//         }
//         if (i < 0 || j < 0) {
//             return 0;
//         }
//         if(dp.get(i).get(j)!=-1){
//             return dp.get(i).get(j);
//         }
//         int up = uniquePathsSum(i - 1, j,dp);
//         int left = uniquePathsSum(i, j - 1,dp);
//         int ans= up+left;
//         dp.get(i).set(j,ans);
//         return ans;
//     }
// }




    // Tabulation
    public int uniquePaths(int m, int n) {
       int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
         for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int up = dp[i-1][j];
                int left = dp[i][j-1]; 
                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }
}
