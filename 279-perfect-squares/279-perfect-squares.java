class Solution {
    public int numSquares(int n) {
        //1, 4, 9, 16, 25
        //32
        //25, 4, 1, 1, 1,
        //16, 16
        
        // 4 ^ k * (8m + 7)
        //
        if (isPerfectSquare(n)) return 1;
        if (checkRes4(n)) return 4;
        for (int i = 1; i * i < n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
        
    }
    
    private boolean isPerfectSquare(int n) {
        int y = (int) Math.sqrt(n);
        return y * y == n;
    }
    
    private boolean checkRes4(int n) {
        while (n % 4 == 0) {
            n /= 4;
        }
        return n % 8 == 7;
    }
}