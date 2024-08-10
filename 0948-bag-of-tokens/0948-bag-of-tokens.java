class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int start = 0, end = n - 1;
        Arrays.sort(tokens);
        int res = 0;
        while (start <= end) {
            if (tokens[start] <= power) {
                res++;
                power -= tokens[start];
                start++;
            } else if (tokens[end] > tokens[start] && res >= 1) {
                power += tokens[end];
                res--;
                end--;
            } else {
                return res;
            }
        }
        
        return res;
    }
}