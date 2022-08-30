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
    int res = 0;
    public int longestZigZag(TreeNode root) {
        longestLength(root);
        return res - 1;
    }
    
    //[# when visiting left, # when visiting right]
    private int[] longestLength(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        
        int[] left = longestLength(root.left);
        int leftRight = left[1];
        int[] right = longestLength(root.right);
        int rightLeft = right[0];
        res = Math.max(Math.max(1 + rightLeft, 1 + leftRight), res);
        return new int[]{1 + leftRight, 1 + rightLeft};
    }
}