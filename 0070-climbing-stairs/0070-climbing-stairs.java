class Solution {
    public int climbStairs(int n) {
        if(n<=0){
            return 0;
        }
        int[]memo=new int[n+1];
        if(n>=1){
            memo[1]=1;
        }
        return fib(n,memo);
    }
    private static int fib(int n, int []memo){
        if(n==0){
            return 1;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        int result=fib(n-1,memo)+fib(n-2,memo);
        memo[n]=result;
    return result;
    }
}