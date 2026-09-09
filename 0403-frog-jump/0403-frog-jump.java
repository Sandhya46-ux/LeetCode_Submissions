class Solution {

    Boolean[][] dp;

    public boolean canCross(int[] stones) {

        int n = stones.length;

        if (stones[1] != 1)
            return false;

        dp = new Boolean[n][n + 1];

        return solve(stones, 1, 1);
    }

    boolean solve(int[] stones, int i, int k) {

        if (i == stones.length - 1)
            return true;

        if (dp[i][k] != null)
            return dp[i][k];

        for (int jump = k - 1; jump <= k + 1; jump++) {

            if (jump <= 0)
                continue;

            int next = stones[i] + jump;

            for (int j = i + 1; j < stones.length; j++) {

                if (stones[j] == next) {

                    if (solve(stones, j, jump))
                        return dp[i][k] = true;

                    break;
                }

                if (stones[j] > next)
                    break;
            }
        }

        return dp[i][k] = false;
    }
}

// class Solution {

//     Boolean[][] dp;

//     public boolean canCross(int[] stones) {
//         int n = stones.length;
//         dp = new Boolean[n][n + 1];
//         return solve(stones, 1, 1);
//     }
//     boolean solve(int[] stones, int i, int k) {
//         if (i == stones.length - 1)
//             return true;
//         if (dp[i][k] != null)
//             return dp[i][k];
//         for (int jump = k - 1; jump <= k + 1; jump++) {
//             if (jump <= 0)
//                 continue;
//             int next = stones[i] + jump;
//             for (int j = i + 1; j < stones.length; j++) {
//                 if (stones[j] == next) {
//                     if (solve(stones, j, jump))
//                         return dp[i][k] = true;
//                     break;
//                 }
//                 if (stones[j] > next)
//                     break;
//             }
//         }
//         return dp[i][k] = false;
//     }
// }


// class Solution {

//     public boolean canCross(int[] stones) {
//         return solve(stones, 1, 1);
//     }

//     boolean solve(int[] stones, int i, int k) {

//         if (i == stones.length - 1)
//             return true;

//         for (int jump = k - 1; jump <= k + 1; jump++) {

//             if (jump <= 0)
//                 continue;

//             int next = stones[i] + jump;

//             for (int j = i + 1; j < stones.length; j++) {

//                 if (stones[j] == next) {

//                     if (solve(stones, j, jump))
//                         return true;

//                     break;
//                 }

//                 if (stones[j] > next)
//                     break;
//             }
//         }

//         return false;
//     }
// }



// class Solution {

//     public boolean canCross(int[] stones) {

//         if (stones[1] != 1)
//             return false;

//         return solve(stones, 1, 1);
//     }

//     boolean solve(int[] stones, int i, int k) {

//         if (i == stones.length - 1)
//             return true;

//         for (int jump = k - 1; jump <= k + 1; jump++) {

//             if (jump <= 0)
//                 continue;

//             int next = stones[i] + jump;

//             for (int j = i + 1; j < stones.length; j++) {

//                 if (stones[j] == next) {

//                     if (solve(stones, j, jump))
//                         return true;

//                     break;
//                 }

//                 if (stones[j] > next)
//                     break;
//             }
//         }
//         return false;
//     }
// }