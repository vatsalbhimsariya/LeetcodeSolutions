        import java.util.Arrays;

class Solution {
    private int[] memo;
    private int[] nums;

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        
        this.nums = nums;
        // memo size is N, storing max money up to index i
        memo = new int[n];
        // Initialize with -1 to denote uncalculated states
        Arrays.fill(memo, -1);
        
        // --- Initialize Base Cases (DP[0] and DP[1]) ---
        // Base Case DP[0]
        memo[0] = nums[0];
        
        // Base Case DP[1]
        memo[1] = Math.max(nums[0], nums[1]);
        
        // The goal is the max money up to the last house (N-1)
        return robUpTo(n - 1);
    }

    /**
     * Recursively calculates the maximum money that can be robbed up to house 'i'.
     */
    private int robUpTo(int i) {
        
        // 1. Base Case (i < 0): Used when calling robUpTo(0 - 2)
        if (i < 0) {
            return 0; 
        }
        
        // 2. Base Cases (i=0, i=1): Already initialized in the memo array
        if (i == 0 || i == 1) {
            return memo[i]; 
        }
        
        // 3. Memoization Check
        if (memo[i] != -1) {
            return memo[i];
        }

        // 4. Recurrence: Max(Rob i + DP[i-2], Skip i + DP[i-1])
        
        // Choice 1: Rob house i
        int choice1_rob = nums[i] + robUpTo(i - 2);
        
        // Choice 2: Skip house i
        int choice2_skip = robUpTo(i - 1);

        // Store and return
        int result = Math.max(choice1_rob, choice2_skip);
        memo[i] = result;
        
        return result;
    }
}

