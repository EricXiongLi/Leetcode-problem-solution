class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0;
        int maxRes = 0;
        int tmp = 0;
        for (int i = 31; i >=0; i--) {
            mask = mask | (1 << i);
            Set<Integer> hs = new HashSet<>();
            for (int num: nums) {
                hs.add(num & mask);
            }
            tmp = maxRes | (1 << i);
            for (int e: hs) {
                if (hs.contains(e ^ tmp)) {
                    maxRes = tmp;
                    break;
                }
            }
        }
        return maxRes;
    }
}

//tc: O(32 * n) sc: O(n)