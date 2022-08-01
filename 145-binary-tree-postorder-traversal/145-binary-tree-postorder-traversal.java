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
    public List<Integer> postorderTraversal(TreeNode root) {
         Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
             while (root != null) {
                 stack.push(root);
                 root = root.left;
             }
            TreeNode cur = stack.pop();
            if (cur.right == null || prev == cur.right) {
                res.add(cur.val);
                prev = cur;
                root = null;
            } else {
                stack.push(cur);
                root = cur.right;
            }
        }
        return res;
        
        
        
    }
}