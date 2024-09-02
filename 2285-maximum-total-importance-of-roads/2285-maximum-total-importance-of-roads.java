class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degree = new int[n];
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        Arrays.sort(degree);
        long res = 0L;
        for (int i = 1; i <= n; i++) {
            res += (long) i * degree[i - 1];
        }
        
        return res;
    }
}