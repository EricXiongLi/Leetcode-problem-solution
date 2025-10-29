class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }
            if (count < 0) {
                res += Math.abs(count);
                count = 0;
            }
        }

        return res + count;
    }
}