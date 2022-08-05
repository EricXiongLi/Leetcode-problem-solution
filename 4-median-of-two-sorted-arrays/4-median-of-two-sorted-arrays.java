class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length,  n = nums2.length;
        int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        int a1 = findKthNum(nums1, 0, nums2, 0, left), a2 = findKthNum(nums1, 0, nums2, 0, right);
        return (a1 + a2) * 0.5;
    }
    
    public int findKthNum(int[] nums1, int p1, int[] nums2, int p2, int k) {
        //base:
        if (k == 1) {
            if (p1 == nums1.length) return nums2[p2];
            else if (p2 == nums2.length) return nums1[p1];
            else return nums1[p1] < nums2[p2] ? nums1[p1] : nums2[p2];
        }
        if (p1 == nums1.length) {
            return (nums2[p2 + k - 1]);
        }
        if (p2 == nums2.length) {
            return nums1[p1 + k - 1];
        }
        
        int newP1 = p1 + k / 2 - 1;
        int newP2 = p2 + k / 2 - 1;
        if (newP1 >= nums1.length) {
            if (nums1[nums1.length - 1] > nums2[newP2]) {
                return findKthNum(nums1, p1, nums2, newP2 + 1, k - k/2);
            } else {
                return findKthNum(nums1, nums1.length, nums2, p2, k - (nums1.length - p1));
            }
        } else if (newP2 >= nums2.length) {
            if (nums2[nums2.length - 1] > nums1[newP1]) {
                return findKthNum(nums1, newP1 + 1, nums2, p2, k - k / 2);
            } else {
                return findKthNum(nums1, p1, nums2, nums2.length, k - (nums2.length - p2));
            }
        } else {
            if (nums1[newP1] <= nums2[newP2]) {
                return findKthNum(nums1, newP1 + 1, nums2, p2, k - k / 2);
            } else {
                return findKthNum(nums1, p1, nums2, newP2 + 1, k - k / 2);
            }
        }
    }
}