import java.util.*;
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int[] dp=new int[n];
        int[] parent=new int[n];
        Arrays.fill(dp,1);
        
        for(int i=0;i<n;i++){
            parent[i]=i;
        
            for(int j=0;j<i;j++){
                if(nums[i] % nums[j]==0  && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
        }
        int max=0;
        int last=0;
        for(int i=0;i<n;i++){
            if(dp[i]>max){
                max=dp[i];
                last=i;
            }
        }
        ArrayList<Integer> lis=new ArrayList<>();

        while(parent[last]!=last){
            lis.add(nums[last]);
            last=parent[last];
        }

        lis.add(nums[last]);

        int left=0;
        int right=lis.size()-1;

        while(left<right){

        int temp=lis.get(left);
        lis.set(left,lis.get(right));
        lis.set(right,temp);

        left++;
        right--;
        }
        return lis;
    }
}