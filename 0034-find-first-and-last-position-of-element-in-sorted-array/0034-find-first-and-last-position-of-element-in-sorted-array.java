class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstByBinarySearch(nums, target);
        int last = findLastByBinarySearch(nums, target);
        return new int[]{first, last};
    }
    //1,2 ,3 ,4 ,4,5 ,5 ,5 ,5 ,5 ,6 ,6 
    public int findFirstByBinarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        //1, 1
        //l, r
        //lm, 
        //2, 1
        //2, 3 
        
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }
    
    public int findLastByBinarySearch(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        if (left > 0 && nums[left - 1] == target) {
            return left - 1;
        }
        return -1;
    }
    
    
}