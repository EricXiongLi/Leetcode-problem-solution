class Solution {
    public int nthUglyNumber(int n) {
        int index2 = 0;
        int index3 = 0, index5 = 0;
        int next2 = 2;
        int next3 = 3, next5 = 5;

        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = Math.min(Math.min(next2, next3), next5);

            if (res[i] == next2) {
                index2++;
                next2 = res[index2] * 2;
            } 
            if (res[i] == next3) {
                index3++;
                next3 = res[index3] * 3;
            } if (res[i] == next5) {
                index5++;
                next5 = res[index5] * 5;
            }
        }

        return res[n - 1];
    }
}