class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        
        // Basic checks
        if (sum % k != 0) return false;
        int target = sum / k;
        
        // If the largest number > target, it can't fit anywhere
        java.util.Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > target) return false;

        // k buckets to store the current sum of each subset
        int[] subsets = new int[k];
        
        // We start from the end of the sorted array (largest numbers first)
        return backtrack(nums, n - 1, subsets, target);
    }

    private boolean backtrack(int[] nums, int index, int[] subsets, int target) {
        // Base Case: All numbers have been placed
        if (index < 0) return true;

        int selected = nums[index];
        for (int i = 0; i < subsets.length; i++) {
            // Try placing 'selected' in bucket i
            if (subsets[i] + selected <= target) {
                subsets[i] += selected;
                
                if (backtrack(nums, index - 1, subsets, target)) {
                    return true;
                }
                
                // Backtrack: Remove the number and try the next bucket
                subsets[i] -= selected;
            }
            
            // Optimization: If the bucket is empty and we couldn't fit the 
            // number, it won't fit in any other empty bucket either.
            if (subsets[i] == 0) break;
        }
        
        return false;
    }
}