/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Set<Integer> set;
    TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        res = null;
        set = new HashSet<>();
        for (TreeNode node : nodes) {
            set.add(node.val);
        }
        containsQuantity(root, nodes.length);
        return res;
    }
    
    private int containsQuantity(TreeNode root, int size) {
        if (root == null) {
            return 0;
        }
        int left = containsQuantity(root.left, size);
        int right = containsQuantity(root.right, size);
        int cur = left + right + (set.contains(root.val) ? 1 : 0);
        if (cur == size && res == null) {
            res = root;
        }
        return cur;
    }
}