class Solution {
    public int minCostClimbingStairs(int[] cost) {
       int n=cost.length;
       if(n==0) return 0;
       if(n==1) return (cost[0]); 

       int dpn1=cost[1];
       int dpn2=cost[0];
       for(int i=2;i<n;i++){
        int dp= cost[i]+ Math.min(dpn1,dpn2);
        dpn2=dpn1;
        dpn1=dp;
       }
       return Math.min(dpn1, dpn2);
    }
}