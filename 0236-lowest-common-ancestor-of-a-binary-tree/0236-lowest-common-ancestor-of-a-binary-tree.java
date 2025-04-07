/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return res;
    }

    //how many p and q are included in the subtree
    public int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;
        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int self = (root == p || root == q) ? 1 : 0;
        int cur = left + right + self;
        if (cur == 2 && res == null) {
            res = root;
        }
        return left + right + self;
    }
}