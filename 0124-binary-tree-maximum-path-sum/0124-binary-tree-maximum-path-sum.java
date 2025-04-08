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
    public int res = -1001;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return res;
    }

    //the path sum of left right direction or left direction including root itslef
    public int maxPath(TreeNode root) {
        if (root == null) return 0;
        int left = maxPath(root.left);
        int right = maxPath(root.right);

        int cur = Math.max(Math.max(left, right), 0) + root.val;
        int curMax = 0;
        if (left > 0) {
            curMax += left;
        }
        if (right > 0) {
            curMax += right;
        }
        res = Math.max(curMax + root.val, res);
        return cur;
    }
}