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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        q.offer(root);

        while (!q.isEmpty()) {
            int sz = q.size();
            List<Integer> cur = new LinkedList<>();

            for (int i = 0; i < sz; i++) {
                TreeNode node = q.poll();
                cur.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(cur);
        }

        return res;


    }
}