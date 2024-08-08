class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        if (s.replaceAll("0", "").length() < k) {
            return "";
        }
        int start = 0;
        String res = "";
        int count = 0;
        for (int end = 0; end < s.length(); end++) {
            if (s.charAt(end) == '1') {
                count++;
            }
            while (count >= k) {
                if (res.length() == 0 || end - start + 1 < res.length() || end - start + 1 == res.length() && s.substring(start, end + 1).compareTo(res) < 0) {
                    res = s.substring(start, end + 1);
                }
                if (s.charAt(start) == '1') {
                    count--;
                }
                start++;
            }
        }
        
        return res;
    }
}