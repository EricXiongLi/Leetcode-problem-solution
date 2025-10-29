class Solution {
    public int maxDepth(String s) {
        int count = 0, res = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')'){
                count--;
            }

            res = Math.max(res, count);
        }

        return res;

    }
}