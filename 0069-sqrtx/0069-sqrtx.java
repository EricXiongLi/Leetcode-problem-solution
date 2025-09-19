class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        long num;
        //<=. >
        //l, r
        //m
        //. lrm
        //r
        while (l <= r) {
            int m = l + (r - l) / 2;
            num = (long) m * m;
            if (num <= x) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return l - 1;
    }
}