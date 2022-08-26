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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null && root.right != null) {
                return root.right;
            } else if (root.right == null && root.left != null) {
                return root.left;
            } else {
                TreeNode mostLeft = root.right;
                while (mostLeft.left != null) {
                    mostLeft = mostLeft.left;
                }
                root.val = mostLeft.val;
                root.right = deleteNode(root.right, root.val);
                return root;
            }
        }
    }
}