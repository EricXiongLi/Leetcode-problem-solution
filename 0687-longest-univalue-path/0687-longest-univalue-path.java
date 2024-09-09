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
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return Math.max(0, res - 1);
    }
    
    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = dfs(node.left);
        int r = dfs(node.right);
        int L = 0, R = 0;
        if (node.left != null && node.left.val == node.val) {
            L = l;
        }
        
        if (node.right != null && node.right.val == node.val) {
            R = r;
        }
        
        res = Math.max(res, L + R + 1);
        return Math.max(L, R) + 1;
    }
}