class Solution {
    public int kthGrammar(int n, int k) {
        return helper(n - 1, k - 1);
    }
    
    private int helper(int n, int k) {
        if (n == 0) {
            return 0;
        }
        int upper = helper(n - 1, k / 2);
        int remainder = k % 2;
        if ((upper == 1 && remainder == 0) || (upper == 0 && remainder == 1)) {
            return 1;
        } else {
            return 0;
        }
    }
}