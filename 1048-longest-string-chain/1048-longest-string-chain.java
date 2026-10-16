// import java.util.*;

// class Solution {
//     public int longestStrChain(String[] words) {
//         Arrays.sort(words, (a, b) -> a.length() - b.length());
//         return solve(words, words.length - 1, -1);
//     }
//     public int solve(String[] words, int i, int prev) {
//         if (i < 0) {
//             return 0;
//         }
//         int notTake = solve(words, i - 1, prev);
//         int take = 0;
//         if (prev == -1 || check(words[i], words[prev])) {
//             take = 1 + solve(words, i - 1, i);
//         }
//         return Math.max(take, notTake);
//     }
//     public boolean check(String a, String b) {
//         if (b.length() - a.length() != 1) {
//             return false;
//         }
//         int i = 0, j = 0;
//         while (i < a.length() && j < b.length()) {
//             if (a.charAt(i) == b.charAt(j)) {
//                 i++;
//             }
//             j++;
//         }
//         return i == a.length();
//     }
// }




//Memoization
// import java.util.*;

// class Solution {
//     public int longestStrChain(String[] words) {
//         Arrays.sort(words, (a, b) -> a.length() - b.length());
//         int n = words.length;
//         int[][] dp = new int[n][n + 1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return solve(words, n - 1, -1, dp);
//     }
//     public int solve(String[] words, int i, int prev, int[][] dp) {
//         if (i < 0) {
//             return 0;
//         }
//         if (dp[i][prev + 1] != -1) {
//             return dp[i][prev + 1];
//         }
//         int notTake = solve(words, i - 1, prev, dp);
//         int take = 0;
//         if (prev == -1 || check(words[i], words[prev])) {
//             take = 1 + solve(words, i - 1, i, dp);
//         }
//         return dp[i][prev + 1] = Math.max(take, notTake);
//     }
//     public boolean check(String a, String b) {
//         if (b.length() - a.length() != 1) {
//             return false;
//         }
//         int i = 0, j = 0;

//         while (i < a.length() && j < b.length()) {
//             if (a.charAt(i) == b.charAt(j)) {
//                 i++;
//             }
//             j++;
//         }
//         return i == a.length();
//     }
// }




//Tabulation
import java.util.*;
class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b) -> a.length()-b.length());

        int n=words.length;
        int[][] dp=new int[n+1][n+1];
        for (int i=1;i<=n;i++){
            for (int prev=0;prev<=n;prev++){
                int notTake = dp[i - 1][prev];
                int take=0;
                if (prev==0 || check(words[i-1],words[prev-1])){
                    take=1+dp[i - 1][i];
                }
                dp[i][prev]=Math.max(take,notTake);
            }
        }

        return dp[n][0];
    }

    public boolean check(String a,String b){
        if (b.length() - a.length()!=1){
            return false;
        }
        int i=0, j=0;
        while (i<a.length() && j<b.length()){
            if (a.charAt(i)==b.charAt(j)){
                i++;
            }
            j++;
        }
        return i==a.length();
    }
}