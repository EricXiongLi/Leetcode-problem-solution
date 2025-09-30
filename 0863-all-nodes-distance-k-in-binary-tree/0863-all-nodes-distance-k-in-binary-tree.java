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
    Map<Integer, List<Integer>> graph = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildGraph(root);

        List<Integer> res = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        dfs(target.val, k, res, visited);
        return res;
    }

    public void dfs(int cur, int k, List<Integer> res, Set<Integer> visited) {
        if (k == 0) {
            res.add(cur);
            return;
        } 

        for (int nei : graph.getOrDefault(cur, new ArrayList<Integer>())) {
            if (!visited.contains(nei)) {
                visited.add(nei);
                dfs(nei, k - 1, res, visited);
                visited.remove(nei);
            }
        }
    }

    public void buildGraph(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            graph.computeIfAbsent(root.val, v -> new ArrayList<Integer>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, v -> new ArrayList<Integer>()).add(root.val);
            buildGraph(root.left);
        }

        if (root.right != null) {
            graph.computeIfAbsent(root.val, v -> new ArrayList<Integer>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, v -> new ArrayList<Integer>()).add(root.val);
            buildGraph(root.right);
        }

    }
}