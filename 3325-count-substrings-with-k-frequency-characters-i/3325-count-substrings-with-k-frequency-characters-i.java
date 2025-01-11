class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int l = 0;
        int res = 0;
        int[] cnt = new int[26];
        for (int r = 0; r < n; r++) {
            cnt[s.charAt(r) - 'a']++;
            while (l <= r && cnt[s.charAt(r) - 'a'] >= k) {
                res += (n - r);
                cnt[s.charAt(l) - 'a']--;
                l++;
            }
        }
        return res;
    }
}