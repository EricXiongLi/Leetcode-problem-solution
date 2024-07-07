class Solution {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            long b = c - a * a;
            if (isPerfectSquare(0, b, b)) {
                return true;
            }
        }
        return false;
    }
    
    //is there a num x in [lower, upper] such that x ^ 2 = target
    public boolean isPerfectSquare(long lower, long upper, long target) {
        if (lower * lower > target) {
            return false;
        }
        
        while (lower <= upper) {
            long mid = lower + upper >> 1;
            if (mid * mid == target) {
                return true;
            } else if (mid * mid < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        
        return false;
    }
}

//tc: O(√c * logc)
//sc: O(logc)