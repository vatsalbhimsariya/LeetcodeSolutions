class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        // If the sum is odd, we can't split it into two equal integer halves
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        
        // dp[i] will be true if a sum of i is possible
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // Base case: We can always make a sum of 0 (by picking nothing)

        for (int num : nums) {
            // We walk BACKWARDS from target to num
            // Walking backwards prevents using the same number multiple times
            for (int i = target; i >= num; i--) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
            
            // Optimization: If we already found the target, we can stop
            if (dp[target]) return true;
        }

        return dp[target];
    }
}