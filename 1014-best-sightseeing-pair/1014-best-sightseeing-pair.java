class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        //max(values[i] + i + values[j] - j), i < j
        int n = values.length;
        
        int res = Integer.MIN_VALUE;
        
        int maxSoFar = values[n - 1] - (n - 1);
        for (int i = n - 2; i >= 0; i--) {
            res = Math.max(res, values[i] + i + maxSoFar);
            maxSoFar = Math.max(maxSoFar, values[i] - i);
        }
        return res;
    }
}