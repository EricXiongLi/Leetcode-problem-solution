class Solution {
    public int findKthLargest(int[] nums, int k) {
        // 1, 2, 3
//         3 => 
        int n = nums.length;
        k = n - k;
        return quickSelect(nums, k, 0, n - 1);
    }
    
    public int quickSelect(int[] nums, int k, int l, int r) {
        int pivot = nums[r], p = l;
        // 1, 2, 5, 4, 3 => smaller..., 3, greatrer..
        for (int i = l; i < r; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, p);
                p++;
            }
        }
        swap(nums, r, p);
        if (k < p) {
            return quickSelect(nums, k, l, p - 1);
        } else if (k > p) {
            return quickSelect(nums, k, p + 1, r);
        } else {
            return nums[p];
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 