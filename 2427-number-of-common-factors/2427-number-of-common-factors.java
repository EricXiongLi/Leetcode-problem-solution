class Solution {
    public int commonFactors(int a, int b) {
        int count = 0;
        for (int i = 1; i <= gcd(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
    
    int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
        
    }
}

//tc: O(log(max(a, b)))
//sc: O(1)