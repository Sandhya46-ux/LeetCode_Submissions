// class Solution {
//     public int minDistance(String word1, String word2) {
//         return solve(word1,word2,word1.length(),word2.length());
//     }
//     public int solve(String word1, String word2,int i,int j){
//         if(i==0)return j;
//         if(j==0)return i;
//         if(word1.charAt(i-1)==word2.charAt(j-1))return solve(word1,word2,i-1,j-1);
//         int in=solve(word1,word2,i,j-1);
//         int d=solve(word1,word2,i-1,j);
//         int r=solve(word1,word2,i-1,j-1);
//         return 1+Math.min(in,Math.min(d,r));
//     }
// }



class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int[] row :dp) Arrays.fill(row,-1);
        return solve(word1,word2,word1.length(),word2.length(),dp);
    }
    public int solve(String word1, String word2,int i,int j,int[][] dp){
        if(i==0)return j;
        if(j==0)return i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i-1)==word2.charAt(j-1))return solve(word1,word2,i-1,j-1,dp);
        int in=solve(word1,word2,i,j-1,dp);
        int d=solve(word1,word2,i-1,j,dp);
        int r=solve(word1,word2,i-1,j-1,dp);
        dp[i][j]= 1+Math.min(in,Math.min(d,r));
        return dp[i][j];
    }
}