class Solution {
    public int change(int amount, int[] coins) {
        // dp[i] = number of ways to make amount i
        int[] dp = new int[amount + 1];
        
        // Base case: There is 1 way to make 0 amount (by picking nothing)
        dp[0] = 1;

        for (int coin : coins) {
            // FORWARD walk: allows using the same coin multiple times
            for (int i = coin; i <= amount; i++) {
                // Total ways = (Ways without this coin) + (Ways using this coin)
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }
}