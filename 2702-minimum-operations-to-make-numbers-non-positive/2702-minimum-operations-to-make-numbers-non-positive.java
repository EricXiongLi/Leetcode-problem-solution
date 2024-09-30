class Solution {
    public int minOperations(int[] nums, int x, int y) {
        int max = Arrays.stream(nums).max().getAsInt();
        
        int l = 0, r = max;
        while (l <= r) {
            int m = l + r >> 1;
            if (isPossible(nums, x, y, m)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        
        return l;
    }
    
    private boolean isPossible(int[] nums, int x, int y, int m) {
        long times = 0;
        for (int num : nums) {
            long left = (long) num - (long)(m) * y;
            if (left > 0) {
                times += (left + x - y - 1) / (x - y);
            }
        }
        
        return times <= m;
    }
}

//f, t
//lm r
//.   lrm
//r