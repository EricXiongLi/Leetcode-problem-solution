class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0, l1 = nums1.length, l2 = nums2.length;
        int[] ans = new int[l1 + l2];
        int index = 0;
        while (p1 < l1 && p2 < l2) {
            if (nums1[p1] == nums2[p2]) {
                if (index == 0 || nums1[p1] != ans[index - 1]) {
                    ans[index] = nums1[p1];
                index++;
                }
                p1++;
                p2++;
            } else {
                if (nums1[p1] < nums2[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}

//tc: O(mlogm + nlogn)
//sc: O(m + n)