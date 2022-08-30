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
    public int longestConsecutive(TreeNode root) {
        longestPath(root);
        return res;
    }
    
    //[longtes incresing path, longest decreasing path]
    private int[] longestPath(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = longestPath(root.left);
        int leftIn = left[0], leftDe = left[1];
        int[] right = longestPath(root.right);
        int rightIn = right[0], rightDe = right[1];
        
        int curIn = 1, curDe = 1;
        if (root.left != null) {
            if (root.left.val == root.val - 1) {
                curDe += leftDe;
            }
            if (root.left.val == root.val + 1) {
                curIn += leftIn;
            }
        }
        if (root.right != null) {
            if (root.right.val == root.val - 1) {
                curDe = Math.max(curDe, 1 + rightDe);
            }
            if (root.right.val == root.val + 1) {
                curIn = Math.max(curIn, 1 + rightIn);
            }
        }
        
        res = Math.max(curIn + curDe - 1, res);
        return new int[]{curIn, curDe};
    }
}