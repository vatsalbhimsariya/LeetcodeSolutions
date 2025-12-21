class Solution {
    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int MOD = 1_000_000_007;
        int[] dp = new int[n + 1];
        
        dp[0] = 1; // Base case: 1 way to decode 0 keys

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1]; // Step of size 1 (always possible)
            
            // Maximum steps possible for this digit
            int maxStep = (pressedKeys.charAt(i - 1) == '7' || pressedKeys.charAt(i - 1) == '9') ? 4 : 3;
            
            // Try taking steps of size 2, 3, (and 4 if applicable)
            for (int step = 2; step <= maxStep && i - step >= 0; step++) {
                // We can only take a larger step if all characters in that step are THE SAME
                if (pressedKeys.charAt(i - 1) == pressedKeys.charAt(i - step)) {
                    dp[i] = (dp[i] + dp[i - step]) % MOD;
                } else {
                    // If the character changes, we can't take any more multi-steps
                    break;
                }
            }
        }
        
        return dp[n];
    }
}