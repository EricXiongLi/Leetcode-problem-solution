class Solution {
    public int minAddToMakeValid(String s) {
        // unmatched left parentesse, and right parenthese
        int left = 0, right = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        
        return left + right;
    }
}