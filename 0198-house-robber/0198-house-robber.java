class Solution {
    // 1. These are class-level "memory" slots
    private int[] nums; 
    private int[] memo;

    public int rob(int[] nums) {
        // 2. We save the input into our class memory
        this.nums = nums; 
        
        this.memo = new int[nums.length];
        Arrays.fill(memo, -1);

        // 3. Now we only need to pass the index!
        return robUpTo(nums.length - 1);
    }

    private int robUpTo(int i) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];

        // 4. We access the money using 'this.nums' directly
        int rob = this.nums[i] + robUpTo(i - 2);
        int skip = robUpTo(i - 1);

        return memo[i] = Math.max(rob, skip);
    }
}