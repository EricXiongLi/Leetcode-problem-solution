class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        
        int idx = 0;
        int BIAS = 50;
        int[] cnt = new int[2 * BIAS + 1];
        int l = 0;
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int r = 0; r < n; r++) {
            cnt[nums[r] + BIAS]++;
            while (r - l + 1 > k) {
                cnt[nums[l] + BIAS]--;
                l++;
            }
            if (r - l + 1 == k) {
                int count = 0;
                for (int i = 0; i < BIAS; i++) {
                    count += cnt[i];
                    if (count >= x) {
                        res[idx] = i - BIAS;
                        break;
                    }
                }
                idx++;
            }
        }
        return res;
    }
}