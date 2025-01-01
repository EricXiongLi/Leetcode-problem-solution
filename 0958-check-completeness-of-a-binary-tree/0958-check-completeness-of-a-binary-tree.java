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
    public boolean isCompleteTree(TreeNode root) {
        //Inspired by others
        //利用完全二叉树层序遍历时节点连续出现的性质，遍历到null之后再遍历到非null则说明不连续
        //If is complete, then the nodes must be consecutive
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode prev = root;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (prev == null && node != null) {
                return false;
            }
            if (node != null) {
                q.offer(node.left);
                q.offer(node.right);
            }
            prev = node;
        }
        return true;
    }
}