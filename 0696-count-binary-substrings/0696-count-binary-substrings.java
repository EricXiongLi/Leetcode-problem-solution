class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0, cur = 1, pre = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                cur++;
            } else {
                res += Math.min(cur, pre);
                pre = cur;
                cur = 1;
            }
        }
        
        return res + Math.min(cur, pre);
    }
}