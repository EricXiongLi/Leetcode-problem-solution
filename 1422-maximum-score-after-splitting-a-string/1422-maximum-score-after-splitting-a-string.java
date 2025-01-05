class Solution {
    public int maxScore(String s) {
        // zeros + rightOnes
        //zeros + totalOnes - leftOnes
        //zeros - leftOnes + totalOnes
        int res = Integer.MIN_VALUE;
        int totalOnes = 0;
        int zeros = 0;
        for (int i = 0;i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                zeros++;
            } else {
                totalOnes++;
            }
            res = Math.max(res, zeros - totalOnes);
        }
        if (s.charAt(s.length() - 1) == '1') totalOnes++;
        return res + totalOnes;
    }
}