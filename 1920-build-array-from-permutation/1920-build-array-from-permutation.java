class Solution {
    public int[] buildArray(int[] nums) {
        int n= nums.length;
        ArrayList<Integer> ans=new ArrayList<>(n);
        for(int i=0;i<n;i++){
            ans.add(nums[nums[i]]);
        }
        int[] result=new int[n];
        for (int i=0;i<n;i++){
            result[i]=ans.get(i);
        }
        return result;
    }
}