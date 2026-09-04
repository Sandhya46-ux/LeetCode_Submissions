// class Solution {
//     public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m= obstacleGrid.length;
//         int n=obstacleGrid[0].length;
//         return solve(m-1,n-1,obstacleGrid);
//     }
//     public int solve(int i,int j, int[][] grid){
//         if(i<0 ||j<0){
//             return 0;
//         }
//          if (grid[i][j] == 1) {
//             return 0;
//         }
//         if(i==0 && j==0){
//             return 1;
//         }
    
//         int up=solve(i-1,j,grid);
//         int left=solve(i,j-1,grid);
//         return up+left;
//     }
// }


class Solution{
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;

         ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> row=new ArrayList<>();
            for(int j=0;j<n;j++){
                row.add(-1);
            }
            dp.add(row);
        }
        return solve(m - 1, n - 1,obstacleGrid,dp);
    }
    public int solve(int i,int j,int[][] grid, ArrayList<ArrayList<Integer>>dp){
        if(i<0 || j<0){
            return 0;
        }
        if(grid[i][j]==1){
            return 0;
        }
        if(i==0 &&j==0){
            return 1;
        }
        if(dp.get(i).get(j)!=-1){
            return dp.get(i).get(j);
        }
        int up=solve(i-1,j,grid,dp);
        int left=solve(i,j-1,grid,dp);
        int res=up+left;
        dp.get(i).set(j,res);
        return res;
    }
}