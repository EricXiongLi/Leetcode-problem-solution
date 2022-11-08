class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if (n ==0) return "";
        sb.append(s.charAt(0));
        for (int i = 1; i < n; i++) {
            if (sb.length() > 0 && (s.charAt(i) ^ 32) == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}