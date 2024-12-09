class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;
        return quickSelect(nums, k, 0, n - 1);
    }
    
    public int quickSelect(int[] nums, int k, int l, int r) {
        int ran  = l + (int) (Math.random() * (r - l));
        swap(nums, ran, r);
        int pivot = nums[r], p = l;
        for (int i = l; i < r; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, p);
                p++;
            }
        }
        swap(nums, r, p);
        if (p == k) {
            return nums[p];
        } else if (p < k) {
            return quickSelect(nums,k, p + 1, r);
        } else {
            return quickSelect(nums, k, l, p - 1);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}