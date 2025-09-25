/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }

    public TreeNode helper(int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode cur = new TreeNode(nums[mid]);
        TreeNode left = helper(start, mid - 1);
        TreeNode right = helper(mid + 1, end);

        cur.left = left;
        cur.right = right;

        return cur;
    }
}