class Solution {
    
//MEMOIZATION
    public int uniquePaths(int m,int n ) {
        // int m=grid.length;
        // int n= grid[0].length;
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(-1);
            }
            dp.add(row);
        }
        return uniquePathsSum(m - 1, n - 1,dp);
    }

    public int uniquePathsSum(int i, int j,ArrayList<ArrayList<Integer>>dp) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if(dp.get(i).get(j)!=-1){
            return dp.get(i).get(j);
        }
        int up = uniquePathsSum(i - 1, j,dp);
        int left = uniquePathsSum(i, j - 1,dp);
        int ans= up+left;
        dp.get(i).set(j,ans);
        return ans;
    }
}