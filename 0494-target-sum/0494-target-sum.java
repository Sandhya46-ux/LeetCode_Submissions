class Solution {

    public int solve(int[] nums, int i, int current, int target) {
        if (i == nums.length) {
            if (current == target) {
                return 1;
            } else {
                return 0;
            }
        }
        int plus = solve(nums, i + 1, current + nums[i], target);
        int minus = solve(nums, i + 1, current - nums[i], target);

        return plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums, 0, 0, target);
    }
}