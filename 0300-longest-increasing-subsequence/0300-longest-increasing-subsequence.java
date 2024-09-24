class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        //dp[i]: the ending value of incresing subsequence with length i;
        List<Integer> dp = new ArrayList<>();
        //for each num in nums, do binary search in the existing dp to replace the one that dp[j] >= num && dp[j - 1] < num: greedy
        dp.add(nums[0]);
        for (int i = 1; i < n; i++) {
            int l = 0, r = dp.size() - 1;
            while (l <= r) {
                int m = l + r >> 1;
                if (dp.get(m) < nums[i]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            if (l == dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(l, nums[i]);
            }
        }
        return dp.size();
    }
}

//tc： O（nlogn）
//sc： O（N）

//< < < > >
//l       r
//.   m
//.     l r
//.     m
//    r


//< < <
//l.m r
//    l
//    m
//      l
