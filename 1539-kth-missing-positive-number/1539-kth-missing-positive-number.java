class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = l + r >> 1;
            if (arr[m] - m - 1 < k) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        //arr[r] + k - (arr[r] - r - 1) =  k + r + 1;
        return k + r + 1;
    }
}