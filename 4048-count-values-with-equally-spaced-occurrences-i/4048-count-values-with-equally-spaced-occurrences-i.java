import java.util.*;
class Solution {
    public int countSpecialIntegers(int[] nums) {
       Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
            //map.computeIfAbsent(nums[i],k -> new ArrayList<>().add(i));
        }
        int answer=0;
        for(List<Integer>indices:map.values()){
            if(indices.size()!=3){
                continue;
            }
            int i1=indices.get(0);
             int i2=indices.get(1);
             int i3=indices.get(2);
            if(i2-i1==i3-i2){
                answer++;
            }
        }
        return answer;
    }
}