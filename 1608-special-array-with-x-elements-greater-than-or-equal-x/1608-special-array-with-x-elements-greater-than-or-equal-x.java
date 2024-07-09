class Solution {
    public int specialArray(int[] nums) {
        // k <= n
        int n = nums.length;
        
        int[] freq = new int[n + 1];
        for (int num : nums) {
            freq[Math.min(num, n)]++;
        }
        
        int maxFreq = 0;
        for (int i = n; i >= 0; i--) {
            maxFreq += freq[i];
            if (i == maxFreq) {
                return i;
            }
        }
        
        return -1;
    }
    
}