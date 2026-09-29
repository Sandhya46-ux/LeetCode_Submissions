// class Solution {
//     public String shortestCommonSupersequence(String str1, String str2) {
//         int n=str1.length();
//         int m = str2.length();
//         int i = n;
//         int j = m;
//         StringBuilder sb = new StringBuilder();
//         while (i > 0 && j > 0) {
//             if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//                 sb.append(str1.charAt(i - 1));
//                 i--;
//                 j--;
//             }
//             else {
//                 int left = solve(str1, str2, i - 1, j);
//                 int right = solve(str1, str2, i, j - 1);
//                 if (left > right) {
//                     sb.append(str1.charAt(i - 1));
//                     i--;
//                 } else {
//                     sb.append(str2.charAt(j - 1));
//                     j--;
//                 }
//             }
//         }
//         while (i > 0) {
//             sb.append(str1.charAt(i - 1));
//             i--;
//         }
//         while (j > 0) {
//             sb.append(str2.charAt(j - 1));
//             j--;
//         }
//         return sb.reverse().toString();
//     }
//     private int solve(String str1, String str2, int i, int j) {
//         if (i == 0 || j == 0) {
//             return 0;
//         }
//         if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//             return 1 + solve(str1, str2, i - 1, j - 1);
//         }
//         return  Math.max(solve(str1, str2, i - 1, j),solve(str1, str2, i, j - 1));
//     }
// }




class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        solve(str1, str2, n, m, dp);
        int i = n;
        int j = m;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            }
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            }
            else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {

            sb.append(str2.charAt(j - 1));
            j--;
        }

        return sb.reverse().toString();
    }
    private int solve(String str1, String str2, int i, int j, int[][] dp) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return dp[i][j] =1 + solve(str1, str2, i - 1, j - 1, dp);
        }
        return dp[i][j] =
            Math.max(solve(str1, str2, i - 1, j, dp),solve(str1, str2, i, j - 1, dp));
    }
}




// class Solution {
//     public String shortestCommonSupersequence(String str1, String str2) {
//         int n = str1.length();
//         int m = str2.length();
//         int[][] dp = new int[n + 1][m + 1];
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if (str1.charAt(i - 1) == str2.charAt(j - 1))
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 else
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//             }
//         }
//         int i = n, j = m;
//         StringBuilder sb = new StringBuilder();

//         while (i > 0 && j > 0) {
//             if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//                 sb.append(str1.charAt(i - 1));
//                 i--;
//                 j--;
//             } else if (dp[i - 1][j] > dp[i][j - 1]) {
//                 sb.append(str1.charAt(i - 1));
//                 i--;
//             } else {
//                 sb.append(str2.charAt(j - 1));
//                 j--;
//             }
//         }
//         while (i > 0) {
//             sb.append(str1.charAt(i - 1));
//             i--;
//         }
//         while (j > 0) {
//             sb.append(str2.charAt(j - 1));
//             j--;
//         }
//         return sb.reverse().toString();
//     }
// }
