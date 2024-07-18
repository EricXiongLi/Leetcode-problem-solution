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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode node = new TreeNode(val, root, null);
            return node;
        }
        int level = 1;
        Queue<TreeNode> q = new ArrayDeque();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (level == depth -1 ) {
                    TreeNode left = cur.left;
                    TreeNode right = cur.right;
                    TreeNode newLeft = new TreeNode(val, left, null);
                    TreeNode newRight = new TreeNode(val, null, right);
                    cur.left = newLeft;
                    cur.right = newRight;
                } else {
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }
                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                    
                }
                
            }
            level++;
        }
        
        return root;
    }
}