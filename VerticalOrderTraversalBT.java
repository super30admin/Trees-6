// Time: O(N) | Space: O(N)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        if (root != null) {
            nodeQ.add(root);
            levelQ.add(0);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while (!nodeQ.isEmpty()) {
            int size = nodeQ.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodeQ.poll();
                int level = levelQ.poll();
                if (!map.containsKey(level)) {
                    map.put(level, new ArrayList<>());
                }
                map.get(level).add(currNode.val);
                if (currNode.left != null) {
                    nodeQ.add(currNode.left);
                    levelQ.add(level - 1);
                }
                if (currNode.right != null) {
                    nodeQ.add(currNode.right);
                    levelQ.add(level + 1);
                }
                max = Math.max(max, level);
                min = Math.min(min, level);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        // bucket sort
        for (int i = min; i <= max; i++) {
            List<Integer> currItem = map.get(i);

            result.add(currItem);
        }
        return result;

    }
}