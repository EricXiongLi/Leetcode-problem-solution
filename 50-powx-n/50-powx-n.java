class Solution {
    public double myPow(double x, int n) {
        //case1: n is even: x ^ (n / 2) ^ 2 
        //case2: n is odd: x ^ (n / 2) * x ^ (n / 2) * x
        if (n < 0) return 1 / pow(x, -n);
        return pow(x, n);
    }
    
    public double pow(double x, int n) {
        if (n == 0) return 1;
        double y = pow(x, n / 2);
        if (n % 2 == 0) return y * y;
        return y * y * x;
    }
}

//tc: O(logn) sc: O(logn)