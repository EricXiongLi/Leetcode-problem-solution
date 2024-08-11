class Solution {
    public int squareSum(int n) {
        int res = 0;
        while (n != 0) {
            int digit = n % 10;
            res += digit * digit;
            n /= 10;
        } 
        return res;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = squareSum(squareSum(n));
        while (slow != fast) {
            if (slow == 1) {
                return true;
            }
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }

        return slow == 1;
    }
}