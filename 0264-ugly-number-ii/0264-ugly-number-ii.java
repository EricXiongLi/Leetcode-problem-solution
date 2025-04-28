class Solution {
    public int nthUglyNumber(int n) {
        int[] res = new int[n + 1];
        res[1] = 1;
        int idx = 1;
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        for (int i = 2; i <= n; i++) {
            int a = res[i2] * 2;
            int b = res[i3] * 3;
            int c = res[i5] * 5;

            int min = Math.min(c, Math.min(a, b));

            if (a == min) i2++;
            if (b == min) i3++;
            if (c == min) i5++;
            res[i] = min;
        }

        return res[n];
    }
}