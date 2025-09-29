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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<TreeNode, Integer>(root, 0));
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        map.computeIfAbsent(0, v -> new ArrayList<Integer>()).add(root.val);
        int min = 0, max = 0;
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> cur = queue.poll();
            int col = cur.col;
            TreeNode node = cur.node;

            if (node.left != null) {
                min = Math.min(min, col - 1);
                queue.offer(new Pair<TreeNode, Integer>(node.left, col - 1));
                map.computeIfAbsent(col - 1, v -> new ArrayList<Integer>()).add(node.left.val);
            }
            if (node.right != null) {
                max = Math.max(max, col + 1);
                queue.offer(new Pair<TreeNode, Integer>(node.right, col + 1));
                map.computeIfAbsent(col + 1, v -> new ArrayList<Integer>()).add(node.right.val);
            }
        }

        for (int col = min; col <= max; col++) {
            Collections.sort(map.get(col));
            res.add(map.get(col));
        }

        return res;
    }
}

class Pair<F, S> {
    F node;
    S col;

    public Pair(F node, S col) {
        this.node = node;
        this.col = col;
    }
}