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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        int res = 0;
        q.offer(root);
        
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.val >= low && cur.val <= high) {
                res += cur.val;
            }
            
            if (cur.val >= low && cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.val <= high && cur.right != null) {
                q.offer(cur.right);
            }
        }
        
        return res;
    }
}