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
    private boolean pFound = false;
    private boolean qFound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = LCA(root, p, q);

        return (pFound && qFound) ? node : null;
    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        if (root == p) {
            pFound = true;
            return root;
        }

        if (root == q) {
            qFound = true;
            return root;
        }

        return left == null ? right : right == null ? left : root;
    }
}