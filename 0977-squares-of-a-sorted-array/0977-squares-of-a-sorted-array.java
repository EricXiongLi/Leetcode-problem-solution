class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int sql = nums[l] * nums[l];
            int sqr = nums[r] * nums[r];
            if (sql > sqr) {
                res.add(sql);
                l++;
            } else {
                res.add(sqr);
                r--;
            }
        }
        Collections.reverse(res);
        return res.stream().mapToInt(i -> i).toArray();
    }
}