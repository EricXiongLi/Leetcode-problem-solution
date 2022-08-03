class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, List<int[]>> colToVals = new HashMap<>(); //<col, [depth, value]>
        Map<TreeNode, Integer> position = new HashMap<>(); // <treenode, col of the node>
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        q.offer(root);
        position.put(root, 0);
        int depth = 0;
        colToVals.computeIfAbsent(0, v -> new LinkedList<int[]>()).add(new int[]{depth, root.val});
        int min = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            depth++;
            for (int i = 0; i < sz; i++) {
                TreeNode curNode = q.poll();
                int curCol = position.get(curNode);
                if (curNode.left != null) {
                    q.offer(curNode.left);
                    position.put(curNode.left, curCol - 1);
                    colToVals.computeIfAbsent(curCol - 1, v -> new LinkedList<int[]>()).add(new int[]{depth, curNode.left.val});
                }
                if (curNode.right != null) {
                    q.offer(curNode.right);
                    position.put(curNode.right, curCol + 1);
                    colToVals.computeIfAbsent(curCol + 1, v -> new LinkedList<int[]>()).add(new int[]{depth, curNode.right.val});
                }
                min = Math.min(min, curCol);
            }
        }
        while (colToVals.containsKey(min)) {
            List<Integer> level = new LinkedList<>();    
            Collections.sort(colToVals.get(min), (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
            for (int[] arr : colToVals.get(min)) {
                level.add(arr[1]);
            }
            res.add(level);
            min++;
            
        }
        return res;
    }
}

//tc: O(n log n)
//sc: O(n)