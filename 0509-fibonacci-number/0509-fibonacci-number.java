class Solution {
    // public int fib(int n) {
    //     //recursion
    //     if(n==0||n==1){
    //         return n;
    //     }
    //     return fib(n-1)+fib(n-2);
    // }
    //Memoization
    public int fibMemo(int n, ArrayList<Integer>dp){
        if(n==0||n==1){
            return n;
        }
        if (dp.get(n) != -1) {
            return dp.get(n);
        }
        
        int result = fibMemo(n - 1, dp) + fibMemo(n - 2, dp);
        dp.set(n, result);
        return result;
    }
    public int fib(int n) {
        ArrayList<Integer> dp = new ArrayList<>(Collections.nCopies(n + 1, -1));
        return fibMemo(n, dp);
    }
}