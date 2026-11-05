/**
 * Time Complexity:  O(n)  where n is the number of nodes
 * Space Complexity: O(n)
 */
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
    List<List<Integer>> result;
    int min = 0;
    int max = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        result = new ArrayList<>();
        Map<Integer, List<Integer>> columnToNode  = bfs(root);
        System.out.println("postions " + columnToNode);

        for(int i = min; i<=max; i++){
            if(columnToNode.containsKey(i)){
                result.add(columnToNode.get(i));
            }
        }

        return result;

    }

    Map<Integer, List<Integer>> bfs(TreeNode root) {
        Map<Integer, List<Integer>> columnToNode = new HashMap<>();

        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Pair<TreeNode, Integer> rootPair = new Pair<>(root, 0);

        queue.offer(rootPair);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.getKey();
                int column = pair.getValue();

                min = Math.min(min, column);
                max = Math.max(max, column);

                if (!columnToNode.containsKey(column)) {
                    List<Integer> nodes = new ArrayList<>();
                    columnToNode.put(column, nodes);
                }
                columnToNode.get(column).add(node.val);

                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, column - 1));
                }

                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, column + 1));
                }
            }
        }

        return columnToNode;
    }
}