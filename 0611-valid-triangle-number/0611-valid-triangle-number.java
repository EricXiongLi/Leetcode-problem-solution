class Solution {
    public int triangleNumber(int[] nums) {
        //a + b == c
        //a + b > c
        
        //5, 4, 3, 2, 1
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for (int i = n - 1; i >= 2; i--) {
            int l = 0;
            int r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    count += (r - l);
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}