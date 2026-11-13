
import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;

        Deque<int[]> dq = new ArrayDeque<>();

        long cost = 0;
        long ans = 0;

        int j = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int num = nums[i];
            int count = 1;
            while (!dq.isEmpty() && dq.peekLast()[0] < num) {

                int[] last = dq.pollLast();

                int value = last[0];
                int cnt = last[1];

                count += cnt;

                cost += (long)(num - value) * cnt;
            }

            dq.offerLast(new int[]{num, count});
            while (cost > k) {

                int[] first = dq.pollFirst();

                int value = first[0];
                int cnt = first[1];

                cost -= (long)(value - nums[j]);

                j--;

                if (cnt > 1) {
                    dq.offerFirst(new int[]{value, cnt - 1});
                }
            }
            ans += j - i + 1;
        }

        return ans;
    }
}
