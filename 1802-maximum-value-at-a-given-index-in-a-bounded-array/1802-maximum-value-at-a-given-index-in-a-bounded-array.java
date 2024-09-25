class Solution {
    public int maxValue(int n, int index, int maxSum) {
        //1, 2, 3, 2, 1, 1
        
        //[1, 1, 1, 1..., 2...m-3, m-2, m-1, m, m -1, m - 2, m - 3]
        
        int l = 1, r = maxSum;
        while (l <= r) {
            int m = l + r >> 1;
            if (isPossible((double)m, n, index, maxSum)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        return r;
    }
    
    
    public boolean isPossible(double m, int n, int i, int maxSum) {
        //i, i + 1, ... i + n - 1 - i
        //m , m - 1, 1.
        double rightSum = 0;
        if ((m - (n - 1 - i)) >= 1) {
            rightSum = ((m - 1) + m - (n - 1 - i)) * (n - 1 - i) / 2;
        } else {
            rightSum = (m - 1 + 1) * (m - 1) / 2;
            rightSum += (n - 1 - i - 1 + 1 - (m - 1));
        }
        double leftSum = 0;
        //0, 1, 2, 3, 4 ... i
        //m-i           m-1    m
        if (m - i >= 1) {
            leftSum =  (m - i + m - 1) * i / 2;
        } else {
            leftSum = m * (m - 1) / 2;
            leftSum += (i - (m - 1));
        }
        boolean res = (leftSum + rightSum + m) <= (double)maxSum;
        return res;
    }
}

//

//8, 7, 6, 5, 4 -> 30
