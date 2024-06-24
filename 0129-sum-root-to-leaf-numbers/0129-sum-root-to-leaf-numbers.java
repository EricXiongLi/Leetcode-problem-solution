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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        
        if (root == null) {
            return val;
        }
        
        if (root.left == null && root.right == null) {
            return 10 * val + root.val;
        } else {
            val = val * 10 + root.val;
        }
        
        return dfs(root.left, val) + dfs(root.right, val);
    }
}