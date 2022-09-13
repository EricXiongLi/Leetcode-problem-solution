class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 1, r = (int)1e5;
        //t, t, ..., t, f, ...f
        while (l <= r) {
            int mid = l + r >> 1;
            if (isCutPossible(ribbons, mid, k)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
    
    public boolean isCutPossible(int[] ribbons, int len, int k) {
        int count = 0;
        for (int ribbon : ribbons) {
            count += ribbon / len;
        }
        return count >= k;
    }
}