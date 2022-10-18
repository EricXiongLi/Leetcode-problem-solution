class Solution {
    int[] nums2;
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        nums2 = new int[n];
        mergesort(nums, 0, n - 1);
        return nums;
    }
    
    public void mergesort(int[] nums, int l, int r) {
        if (l == r) return;
        int m = l + r >> 1;
        mergesort(nums, l, m);
        mergesort(nums, m + 1, r);
        int n = nums.length;
        
        int p1 = l, p2 = m + 1, p3 = l;
        while (p1 <= m && p2 <= r) {
            if (nums[p1] < nums[p2]) {
                nums2[p3] = nums[p1];
                p1++;
            } else {
                nums2[p3] = nums[p2];
                p2++;
            }
            p3++;
        }
        if (p1 > m) {
            for (int i = p2; i <= r; i++) {
                nums2[p3] = nums[i];
                p3++;
            }
        } else {
            for (int i = p1; i <= m; i++) {
                nums2[p3] = nums[i];
                p3++;
            }
        }
        for (int i = l; i <= r; i++) {
            nums[i] = nums2[i];
        }
    }
}

//tc: O(nlogn)
//sc: O(n)