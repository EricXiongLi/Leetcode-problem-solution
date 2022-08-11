class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int sz = triangle.size();
        int[][] dp = new int[sz + 1][sz + 1];
        for (int i = 0; i <= sz; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[1][1] = triangle.get(0).get(0);
        for (int i = 1; i <= sz; i++) {
            for (int j = 1; j <= i; j++) {
                if (i == 1 && j == 1) continue;
                int cur = triangle.get(i - 1).get(j - 1);
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + cur;
            }
        }
        return Arrays.stream(dp[sz]).min().getAsInt();
    }
}