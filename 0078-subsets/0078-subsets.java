class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int[] nums, int index,List<Integer> curr,List<List<Integer>> ans) {
        ans.add(new ArrayList<>(curr));

        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            solve(nums, i + 1, curr, ans);
            curr.remove(curr.size() - 1);
        }
    }
}