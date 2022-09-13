class Solution {
    Set<String> set = new HashSet<>();
    public int longestRepeatingSubstring(String s) {
        // t, t, t, f, f
        int l = 0, r = s.length();
        while (l <= r) {
            int mid = l + r >> 1;
            if (check(s, s.length(), mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }
    //x + len - 1 <= n - 1 => x <= n - len
    public boolean check(String s, int n, int len) {
        for (int i = 0; i <= n - len; i++) {
            String s1 = s.substring(i, i + len);
            if (set.contains(s1)) {
                return true;
            } else {
                set.add(s1);
            }
        }
        return false;
    }
}