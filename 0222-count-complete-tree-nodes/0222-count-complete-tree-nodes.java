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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int left = getLevel(root.left);
        int right = getLevel(root.right);
        int res = 0;
        //left sub tree is complete;
        if (left == right) {
            //left subtree nodes + root;
            res += (1 << left);
            res += (countNodes(root.right));
        } else {
            //right subtree is complete
            res += (1 << right);
            res += countNodes(root.left);
        }
        return res;
    }

    public int getLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getLevel(root.left), getLevel(root.right)) + 1;
    }
}