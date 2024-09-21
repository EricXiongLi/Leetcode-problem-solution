class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 1, r = n;
        while (l <= r) {
            int m = l + r >> 1;
            if (citations[n - m] >= m) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return r;
    }
}