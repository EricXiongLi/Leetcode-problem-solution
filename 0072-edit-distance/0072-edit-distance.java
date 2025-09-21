class Solution {
    public int minDistance(String word1, String word2) {
        //dp[i][j]: the min distance of word1[0...i - 1], word2[0..j - 1]

        //dp[i][j] = 
        //1. i if j = 0
        //2. j if i = 0
        //3. dp[i - 1][j - 1] if word1[i - 1] == word2[j - 1]
        //4. min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1

        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        //i = r -1, j = c - 1

        for (int c = 0; c < l2 + 1; c++) {
            dp[0][c] = c;
        } 

        for (int r = 0; r < l1 + 1; r++) {
            dp[r][0] = r;
        }
        for (int r = 1; r < l1 + 1; r++) {
            for (int c = 1; c < l2 + 1; c++) {
                if (word1.charAt(r - 1) == word2.charAt(c - 1)) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    dp[r][c] = 1 + Math.min(Math.min(dp[r - 1][c], dp[r][c - 1]), dp[r - 1][c- 1]);
                }
            }
        }

        return dp[l1][l2];
    }
}