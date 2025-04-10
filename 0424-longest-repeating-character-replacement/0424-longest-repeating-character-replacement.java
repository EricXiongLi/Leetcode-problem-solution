class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];

        int l = 0;
        int res = 0;
        int maxCount = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map[c - 'A']++;
            maxCount = Math.max(map[c - 'A'], maxCount);
            while (maxCount + k < r - l + 1) {
                char leftC = s.charAt(l);
                map[leftC - 'A']--;
                maxCount = findMax(map);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    public int findMax(int[] nums) {
        return Arrays.stream(nums).max().getAsInt();
    }
}