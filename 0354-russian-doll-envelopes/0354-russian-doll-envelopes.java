class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
        int n=envelopes.length;
        int[] lis=new int[n];
        int size=0;
        for(int[] e:envelopes){
            int height=e[1];
            int low=0;
            int high=size;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if(lis[mid] >= height){
                    high=mid;
                }else{
                    low=mid+1;
                }
            }
            lis[low]=height;
            if (low==size) {
                size++;
            }
        }
        return size;
        }
    }
