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
    Map<TreeNode, TreeNode> parents = new HashMap<>();
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, null);
        Set<Integer> hs = new HashSet<>();
        TreeNode cursor = p;
        while (cursor != null) {
            hs.add(cursor.val);
            cursor = parents.get(cursor);
        }
        TreeNode cursor2 = q;
        while (!hs.contains(cursor2.val)) {
            cursor2 = parents.get(cursor2);
        }
        return cursor2;
        
    }
    
    private void dfs(TreeNode root, TreeNode parent) {
        if (root == null) return;
        parents.put(root, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}