class Solution {
    public int climbStairs(int n) {
       if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1; // W(1) = 1
        }
        
        // Initialize with the ways to reach step 1 and step 2
        int waysPrev2 = 1; // Represents W(i-2), starts at W(1)
        int waysPrev1 = 2; // Represents W(i-1), starts at W(2)
        
        // No need for a separate current variable if we update Prev1 directly
        
        // Loop starts from step i=3 up to n
        for (int i = 3; i <= n; i++) {
            // W(i) = W(i-1) + W(i-2)
            int waysCurrent = waysPrev1 + waysPrev2;
            
            // Shift for the next iteration:
            waysPrev2 = waysPrev1;  // Old W(i-1) becomes the new W(i-2)
            waysPrev1 = waysCurrent; // New W(i) becomes the new W(i-1)
        }

        // If n=2, the loop is skipped, and waysPrev1 (which is 2) is the answer.
        // If n > 2, waysPrev1 holds the final result W(n).
        return waysPrev1; 
    }
}