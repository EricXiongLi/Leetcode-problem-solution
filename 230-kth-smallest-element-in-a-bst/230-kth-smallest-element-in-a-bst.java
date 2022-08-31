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
    List<Integer> res = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return res.get(k - 1);
    }
    
    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (res.size() >= k) {
            return;
        }
        inorder(root.left, k);
        res.add(root.val);
        inorder(root.right, k);
    }
}