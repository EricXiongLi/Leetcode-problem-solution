class Solution {
    public int[] sortArray(int[] nums) {
        //[5, 2, 3, 1]
        // [5, 2], [3, 1]
        //[5] [2], [3], [1];
        int n = nums.length;
        int[] copied = new int[n];
        System.arraycopy(nums, 0, copied, 0, n);
        sort(nums, copied, 0, n - 1);
        return nums;
    }
    
    public void sort(int[] nums, int[] copied, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(nums, copied, left, mid);
        sort(nums, copied, mid + 1, right);
        merge(nums, copied, left, mid, right);
    }
    
    public void merge(int[] nums, int[] copied,  int left, int mid, int right) {
        int p1 = left, p2 = mid + 1, p = left;
        while (p1 <= mid && p2 <= right) {
            if (copied[p1] < copied[p2]) {
                nums[p] = copied[p1];
                p1++;
                p++;
            } else {
                nums[p] = copied[p2];
                p2++;
                p++;
            }
        }
        if (p1 == mid + 1) {
            while (p2 <= right) {
                nums[p] = copied[p2];
                p2++;
                p++;
            }
        } else {
            while (p1 <= mid) {
                nums[p] = copied[p1];
                p1++;
                p++;
            }
        }
        for (int i = left; i <= right; i++) {
            copied[i] = nums[i];
        }
    }
}