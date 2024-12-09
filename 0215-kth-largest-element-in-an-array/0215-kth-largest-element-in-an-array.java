class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quicksort(nums, 0, n - 1, n - k + 1);
    }
    
    int quicksort(int[] nums, int l, int r, int k) {
        int randomIndex = l + (int)(Math.random() * (r - l + 1));
        int pivot = partition(nums, l, r, randomIndex);
        if (pivot == k - 1) return nums[pivot];
        if (k - 1 > pivot) {
            return quicksort(nums, pivot + 1, r, k);
        } else {
            return quicksort(nums, l, pivot - 1, k);
        }
    }
    
    int partition(int[] nums, int l, int r, int pivotId) {
        int pivot = nums[pivotId];
        swap(nums, r, pivotId);
        int wall = l;
        for (int i = l; i <= r - 1; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, wall);
                wall++;
            }
        }
        swap(nums, wall, r);
        return wall;
    }
    
    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}