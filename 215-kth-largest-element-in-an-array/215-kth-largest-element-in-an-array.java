class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = partition(nums, left, right);
        if (pivot == nums.length - k) return nums[pivot];
        if (pivot > nums.length - k) return quickSelect(nums, left, pivot - 1, k);
        return quickSelect(nums, pivot + 1, right, k);
    }
    
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right], wall = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, right);
        return wall;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        
    }
}