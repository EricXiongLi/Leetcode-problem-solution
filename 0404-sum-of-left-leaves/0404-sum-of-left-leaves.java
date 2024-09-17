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
    public int sumOfLeftLeaves(TreeNode root) {
       if (root == null) {
           return 0;
       }
        return helper(root.left, true) + helper(root.right, false);
    }
    
    public int helper(TreeNode root, boolean isLeftChild) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return isLeftChild ? root.val : 0;
        } else {
            return helper(root.left, true) + helper(root.right, false);
        }
    }
}