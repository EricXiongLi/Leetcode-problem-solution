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
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return res;
    }
    
    private int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        //root.val + left, root.val, root.val + right, root.val + left + right
        res = Math.max(res, root.val + Math.max(left, 0) + Math.max(right, 0));
        return Math.max(Math.max(left, right), 0) + root.val;
    }
}