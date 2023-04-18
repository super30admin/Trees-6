import java.util.*;

// Approach: BFS using 2 lists, one for node value and one for position. HashMap to store position
// mapped node values. Position starts at 0 for root, -1 for every .left and +1 for every .right
// from the root.
// Time: O(n)
// Space: O(n)
class BinaryTreeVerticalOrderTraversal_BFS {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        q.add(root);
        cols.add(0);

        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            int currCol = cols.poll();
            if (!map.containsKey(currCol)) {
                map.put(currCol, new ArrayList<>());
            }
            map.get(currCol).add(curr.val);
            if (curr.left != null) {
                q.add(curr.left);
                min = Math.min(min, currCol - 1);
                cols.add(currCol - 1);
            }
            if (curr.right != null) {
                q.add(curr.right);
                max = Math.max(max, currCol + 1);
                cols.add(currCol + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}