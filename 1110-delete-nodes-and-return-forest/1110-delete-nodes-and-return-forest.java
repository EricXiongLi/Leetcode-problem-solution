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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> delete = new HashSet<>();
        for (int val : to_delete) {
            delete.add(val);
        }

        List<TreeNode> res = new ArrayList<>();
        if (!delete.contains(root.val)) res.add(root);
        dfs(root, delete, res);
        return res;
    }

    //1. Every one takes care if their children to be added to res
    public TreeNode dfs(TreeNode cur, Set<Integer> delete, List<TreeNode> res) {
        if (cur == null) {
            return null;
        }

        TreeNode left = dfs(cur.left, delete, res);
        TreeNode right = dfs(cur.right, delete, res);

        if (delete.contains(cur.val)) {
            if (left != null) res.add(left);
            if (right != null) res.add(right);
            return null;
        }

        cur.left = left;
        cur.right = right;

        return cur;


    }
}