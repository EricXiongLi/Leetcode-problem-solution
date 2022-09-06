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
    public TreeNode increasingBST(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        inorder(root, q);
        TreeNode dummy = new TreeNode(-1);
        TreeNode t = dummy;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            cur.left = null;
            t.right = cur;
            t = t.right;
        }
        return dummy.right;
    }
    
    public void inorder(TreeNode root, Queue<TreeNode> q) {
        if (root == null) {
            return;
        }
        inorder(root.left, q);
        q.offer(root);
        inorder(root.right, q);
    }
}