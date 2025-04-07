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
    //Solved it by recalling last time memory
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lowerBound, Integer upperBound) {
        if (root == null) return true;
        if (lowerBound != null && root.val <= lowerBound) return false;
        if (upperBound != null && root.val >= upperBound) return false;
        boolean left = isValidBST(root.left, lowerBound, root.val);
        boolean right = isValidBST(root.right, root.val, upperBound);
        return left && right;
    }

    
}