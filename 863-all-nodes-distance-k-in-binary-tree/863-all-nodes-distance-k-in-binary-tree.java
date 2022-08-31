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
        
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(target.val);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        int depth = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int cur = q.poll();
                if (depth == k) {
                    res.add(cur);
                }
                for (int child : graph.getOrDefault(cur, new ArrayList<Integer>())) {
                    if (!visited.contains(child)) {
                        q.offer(child);
                        visited.add(child);
                    }
                }
            }
            if (depth == k) {
                break;
            }
            depth++;
        }
        return res;
    }
    
    private void buildGraph(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            graph.computeIfAbsent(root.val, v -> new ArrayList<Integer>()).add(root.left.val);
            graph.computeIfAbsent(root.left.val, v -> new ArrayList<Integer>()).add(root.val);
        }
        
        if (root.right != null) {
            graph.computeIfAbsent(root.val, v -> new ArrayList<Integer>()).add(root.right.val);
            graph.computeIfAbsent(root.right.val, v -> new ArrayList<Integer>()).add(root.val);
        }
        buildGraph(root.left);
        buildGraph(root.right);
    }
    
}