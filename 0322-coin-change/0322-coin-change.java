class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp[i] = min coins needed to make amount i
        int[] dp = new int[amount + 1];
        
        // Fill with a value larger than any possible answer (amount + 1)
        java.util.Arrays.fill(dp, amount + 1);
        
        // Base case: 0 coins to make 0 amount
        dp[0] = 0;

        for (int coin : coins) {
            // FORWARD walk: we can reuse the current coin
            for (int i = coin; i <= amount; i++) {
                // Min(Current value, 1 coin + value at (i - coin))
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        // If dp[amount] is still the "Large Number", it's impossible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}