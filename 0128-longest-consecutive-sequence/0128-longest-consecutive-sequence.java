class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int curStreak = 1;
                int cur = num;
                while (set.contains(cur + 1)) {
                    curStreak++;
                    cur++;
                }
                res = Math.max(res, curStreak);
            }
        }

        return res;

    }
}