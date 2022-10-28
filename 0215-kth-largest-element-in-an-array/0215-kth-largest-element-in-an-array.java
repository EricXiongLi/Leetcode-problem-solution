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
        int left = l;
        int right = r - 1;
        while (true) {
            while (left <= r - 1 && nums[left] <= pivot) {
                left++;
            }
            while (right >= l && nums[right] > pivot) {
                right--;
            }
            if (left > right) {
                swap(nums, left, r);
                break;
            }
            swap(nums, left, right);
        }
        return left;
    }
    
    void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}