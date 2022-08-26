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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    
    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;
        boolean left = true, right = true;
        if (root.left != null) {
            left = isValidBST(root.left, lower, root.val);
        }
        if (root.right != null) {
            right = isValidBST(root.right, root.val, upper);
        }
        return left && right;
    }
}