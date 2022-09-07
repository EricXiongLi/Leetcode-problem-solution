class Solution {
    public String minRemoveToMakeValid(String s) {
        int left = 0, right = 0;
        int full = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                right++;
                if (left >= right) {
                    full++;
                    left--;
                }
                right--;
            } else if (c == '('){
                left++;
            }
        }
        left = 0;
        right = 0;
        System.out.println(full);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (left < full) {
                    res.append(c);
                    left++;
                }
            } else if (c == ')') {
                if (right < full && right < left) {
                    res.append(c);
                    right++;
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}