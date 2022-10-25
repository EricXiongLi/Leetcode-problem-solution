class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n + 1];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        int p = 1;
        for (int i = 1; i <= n; i++) {
            int min = Math.min(ugly[p5] * 5, Math.min(ugly[p2] * 2, ugly[p3] * 3));
            if (min == ugly[p5] * 5) {
                p5++;
            }
            if (min == ugly[p2] * 2) {
                p2++;
            }
            if (min == ugly[p3] * 3) {
                p3++;
            }
            ugly[p] = min;
            p++;
        }
        return ugly[n - 1];
        
    }
}

//
//2 -> 2 * 2 -> 2 * 2 * 2

//3 -> 3 * 2 -> 3 * 2 * 2

//5 -> 5 *2 -> 5 *2 *2 


//2 -> 3 -> 2 * 2 -> 5 -> 6 -> 