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
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        set = new HashSet();
        List<TreeNode> res = new ArrayList();
        for (int item : to_delete) {
            set.add(item);
        }
        if (!set.contains(root.val)) {
            res.add(root);
        }
        dfs(root, res);
        return res;
    }
    
    public TreeNode dfs(TreeNode node, List<TreeNode> res) {
        if (node == null) {
            return null;
        }
        node.left = dfs(node.left, res);
        node.right = dfs(node.right, res);
        if (set.contains(node.val)) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
            return null;
        }
        return node;
    }
}

//tc: O(n)
//sc: O(n)