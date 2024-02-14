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

/*
 * Approach:
 * here we have to find the vertical side for the tree, so we have .
 * 1. We'll keep assigning value to the root as a level, for each level, and
 * it's corresponding nodes, we'll make
 * mapping in HashMap
 * 2. Everytie we pull values from Q, we'l update Max and min to perform bucket
 * sort over Hashmap. and get result arranged in order from negative to
 * poastivie values
 * 
 * TC: O(n) - 2 pass
 * SC: O(n/2 + n/2) + O(n) for Queue and Map
 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // base case
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        nodes.add(root);
        level.add(0);

        int min = 0, max = 0;
        while (!nodes.isEmpty()) {
            TreeNode curr = nodes.poll();
            int width = level.poll();

            min = Math.min(min, width); // updating min and max for range to add in map
            max = Math.max(max, width);
            if (!map.containsKey(width)) {
                map.put(width, new ArrayList<>());
            }
            map.get(width).add(curr.val);

            // add children to the queue.
            if (curr.left != null) {
                nodes.add(curr.left);
                level.add(width - 1);
            }
            if (curr.right != null) {
                nodes.add(curr.right);
                level.add(width + 1);
            }
        }

        // traverse through Map with Bucket sort technique - from Min to Max
        // there will not be any values of j that desn't have list! So no need to check
        // null thing.
        for (int j = min; j <= max; j++) {
            result.add(map.get(j));
        }

        return result;
    }
}