class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    public int quickSelect(int[] nums, int l, int r, int k) {
        int p = l, pivot = nums[r];
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, p);
                p++;
            }
        }
        swap(nums, p, r);
        if (nums.length - k == p) return nums[p];
        else if (nums.length - k > p) return quickSelect(nums, p + 1, r, k);
        else return quickSelect(nums, l, p - 1, k);
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}