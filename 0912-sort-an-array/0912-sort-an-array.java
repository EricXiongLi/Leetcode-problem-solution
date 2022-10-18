class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    //1, 2, 3
    
    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int randomIndex = l + (int)(Math.random() * (r - l + 1));
        int partitionIndex = partition(nums, l, r, randomIndex);
        quickSort(nums, l, partitionIndex - 1);
        quickSort(nums, partitionIndex + 1, r);
    }
    
    private int partition(int[] nums, int l, int r, int pivot) {
        int wall = l;
        swap(nums, r, pivot);
        for (int i = l; i < r; i++) {
            if (nums[i] < nums[r]) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, r, wall);
        return wall;
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}