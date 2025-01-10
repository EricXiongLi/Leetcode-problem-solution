class Solution {
    public int takeCharacters(String s, int k) {
        int[] cnt = new int[3];
        int n = s.length();
        int res = Integer.MIN_VALUE;
        int l = 0;
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (int i = 0; i < 3; i++) {
            cnt[i] -= k;
        }

        int[] cur = new int[3];
        for (int r = 0; r < n; r++) {
            cur[s.charAt(r) - 'a']++;
            while (l <= r && (cur[0] > cnt[0] || cur[1] > cnt[1] || cur[2] > cnt[2])) {
                cur[s.charAt(l) - 'a']--;
                l++;
            }
            if (cur[0] <= cnt[0] && cur[1] <= cnt[1] && cur[2] <= cnt[2])res = Math.max(r - l + 1, res);
        }
        return res == Integer.MIN_VALUE ? -1 : n - res;
    }
}