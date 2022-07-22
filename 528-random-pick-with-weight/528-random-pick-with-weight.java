class Solution {
    private int[] sum;
    public Solution(int[] w) {
        int n = w.length;
        sum = new int[n];
        sum[0] = w[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        //第一个>= 随机数的值的index
        int left = 0, right = sum.length - 1;
        int target = (int) (Math.random() * sum[right]) + 1;
        while (left <= right) {
            int mid = left + right >> 1;
            if (sum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */