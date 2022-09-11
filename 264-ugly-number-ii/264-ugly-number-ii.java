class Solution {
    public int nthUglyNumber(int n) {
        //1, 2, 3, 5, 6, 
        //1 -> 2 -> 4
        //1 -> 3 -> 9
        //1- > 5 -> 25
        int p1 = 1, p2 = 1, p5 = 1;
        int product1 = 1, product2 = 1, product5 = 1;
        int p = 1;
        int[] uglyNums = new int[n + 1];
        while (p <= n) {
            uglyNums[p] = Math.min(Math.min(product1, product2), product5);
            p++;
            if (uglyNums[p - 1] == product1) {
                product1 = uglyNums[p1] * 2;
                p1++;
            }
            if (uglyNums[p - 1] == product2) {
                product2 = uglyNums[p2] * 3;
                p2++;
            }
            if (uglyNums[p - 1] == product5) {
                product5 = uglyNums[p5] * 5;
                p5++;
            }
        }
        return uglyNums[n];
    }
}
