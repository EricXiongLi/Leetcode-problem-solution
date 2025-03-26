class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        int n = chars.length;
        while (p < n) {
            int curLen = 1;
            while (p + 1 < n && chars[p + 1] == chars[p]) {
                p++;
                curLen++;
            }
            String ss = String.valueOf(curLen);
            sb.append(chars[p]);
            if (curLen > 1) sb.append(ss);
            p++;
        }

        for (int i = 0; i < sb.length(); i++) {
            chars[i] = sb.charAt(i);
        }
        return sb.length();
    }
    
}