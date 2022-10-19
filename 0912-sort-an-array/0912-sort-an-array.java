class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quicksort(nums, 0, n - 1);
        return nums;
    }
    
    private void quicksort(int[] nums, int l, int r) {
        if (l >= r) return;
        int randomIndex = l + (int)(Math.random() * (r - l + 1));
        int partitionIndex = partition(nums, l, r, randomIndex);
        quicksort(nums, l, partitionIndex - 1);
        quicksort(nums, partitionIndex + 1, r);
    }
    
    private int partition(int[] nums, int l, int r, int i) {
        int pivot = nums[i];
        swap(nums, i, r);
        int wall = l;
        for (int j = l; j <= r - 1; j++) {
            if (nums[j] < pivot) {
                swap(nums, j, wall);
                wall++;
            }
        }
        swap(nums, wall, r);
        return wall;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

//tc: O(nlogn)
//sc: O(logn)