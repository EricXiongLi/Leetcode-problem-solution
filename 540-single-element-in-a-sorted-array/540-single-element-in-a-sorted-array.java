class Solution {
    public int singleNonDuplicate(int[] nums) {
        //n % 2 == 1
        //2, 3, 3
        //l, m, r
        //
        
        int l = 0, r = nums.length - 1;
        int n = nums.length;
        while (l <= r) {
            int mid = l + r >> 1;
            if (mid % 2 == 0) {
                if (mid + 1 < n && nums[mid + 1] == nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        //1,1,2
        
        return nums[l];
    }
}